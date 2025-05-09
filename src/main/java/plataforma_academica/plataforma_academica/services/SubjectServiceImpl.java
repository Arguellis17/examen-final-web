package plataforma_academica.plataforma_academica.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma_academica.plataforma_academica.model.Subject;
import plataforma_academica.plataforma_academica.repositories.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject createSubject(Subject subject) {
        if (subjectRepository.existsByTitle(subject.getTitle())) {
            throw new IllegalArgumentException("Subject with title already exists");
        }
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(Long id, Subject updatedSubject) {
        return subjectRepository.findById(id)
                .map(subject -> {
                    subject.setTitle(updatedSubject.getTitle());
                    subject.setTeacher(updatedSubject.getTeacher());
                    subject.setStudents(updatedSubject.getStudents());
                    subject.setSchedules(updatedSubject.getSchedules());
                    subject.setEvaluations(updatedSubject.getEvaluations());
                    return subjectRepository.save(subject);
                })
                .orElseThrow(() -> new IllegalArgumentException("Subject not found"));
    }

    @Override
    public void deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new IllegalArgumentException("Subject not found");
        }
        subjectRepository.deleteById(id);
    }
}
