package plataforma_academica.plataforma_academica.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class SubjectEnrollmentId implements Serializable {

    private Long studentId;
    private Long subjectId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectEnrollmentId)) return false;
        SubjectEnrollmentId that = (SubjectEnrollmentId) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(subjectId, that.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectId);
    }
}
