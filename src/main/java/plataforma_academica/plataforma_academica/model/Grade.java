package plataforma_academica.plataforma_academica.model;

import java.time.LocalDateTime;

public class Grade {

    private Student student;
    private Evaluation evaluation;
    private Double score;
    private LocalDateTime timestap;
    private List<GradeHistory> history;
}
