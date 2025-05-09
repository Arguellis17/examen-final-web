package plataforma_academica.plataforma_academica.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class SubjectEnrollment {

    @EmbeddedId
    private SubjectEnrollmentId id = new SubjectEnrollmentId();

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("subjectId")
    private Subject subject;

    private LocalDate enrollmentDate;
}
