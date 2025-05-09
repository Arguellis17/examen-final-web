package plataforma_academica.plataforma_academica.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student extends User {

    List<SubjectEnrollment> subjectEnrollments;
}
