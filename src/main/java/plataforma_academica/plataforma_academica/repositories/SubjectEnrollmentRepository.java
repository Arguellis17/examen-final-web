package plataforma_academica.plataforma_academica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plataforma_academica.plataforma_academica.model.SubjectEnrollment;
import plataforma_academica.plataforma_academica.model.SubjectEnrollmentId;

public interface SubjectEnrollmentRepository extends JpaRepository<SubjectEnrollment, SubjectEnrollmentId> {
    boolean existsByStudent_IdAndSubject_Id(Long studentId, Long subjectId);
}
