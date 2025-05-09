package plataforma_academica.plataforma_academica.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma_academica.plataforma_academica.model.*;
import plataforma_academica.plataforma_academica.repositories.SubjectEnrollmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectEnrollmentServiceImpl implements SubjectEnrollmentService {

    private final SubjectEnrollmentRepository repository;

    @Override
    public List<SubjectEnrollment> getAllEnrollments() {
        return repository.findAll();
    }

    @Override
    public Optional<SubjectEnrollment> getEnrollment(Long studentId, Long subjectId) {
        SubjectEnrollmentId id = new SubjectEnrollmentId();
        id.setStudentId(studentId);
        id.setSubjectId(subjectId);
        return repository.findById(id);
    }

    @Override
    public SubjectEnrollment enrollStudent(SubjectEnrollment enrollment) {
        SubjectEnrollmentId id = new SubjectEnrollmentId();
        id.setStudentId(enrollment.getStudent().getCodigoUsuario());
        id.setSubjectId(enrollment.getSubject().getId());
        enrollment.setId(id);

        if (repository.existsById(id)) {
            throw new IllegalArgumentException("Student already enrolled in this subject");
        }
        return repository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long studentId, Long subjectId) {
        SubjectEnrollmentId id = new SubjectEnrollmentId();
        id.setStudentId(studentId);
        id.setSubjectId(subjectId);
        repository.deleteById(id);
    }
}
