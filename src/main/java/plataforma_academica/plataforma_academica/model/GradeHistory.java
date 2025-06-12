package plataforma_academica.plataforma_academica.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class GradeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Grade grade;

    private Double oldScore;
    private Double newScore;

    @ManyToOne
    private Teacher modifiedBy;

    private LocalDateTime modificationDate;
}