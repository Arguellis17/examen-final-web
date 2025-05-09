package plataforma_academica.plataforma_academica.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "evaluation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date evaluationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> grades;
}