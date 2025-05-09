package plataforma_academica.plataforma_academica.services;

import plataforma_academica.plataforma_academica.model.SubjectEnrollment;

import java.util.List;
import java.util.Optional;

public interface SubjectEnrollmentService {
    List<SubjectEnrollment> getAllEnrollments();
    Optional<SubjectEnrollment> getEnrollment(Long studentId, Long subjectId);
    SubjectEnrollment enrollStudent(SubjectEnrollment enrollment);
    void deleteEnrollment(Long studentId, Long subjectId);
}
