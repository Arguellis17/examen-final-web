package plataforma_academica.plataforma_academica.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student extends User {

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<SubjectEnrollment> subjectEnrollments;
}
