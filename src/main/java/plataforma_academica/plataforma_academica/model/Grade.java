package plataforma_academica.plataforma_academica.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_codigo_usuario")
    private Student student;

    @ManyToOne
    private Evaluation evaluation;
    private Double score;
    private LocalDateTime timestap;
    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<GradeHistory> histories;


}
