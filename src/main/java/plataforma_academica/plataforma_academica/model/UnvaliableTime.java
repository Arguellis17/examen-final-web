package plataforma_academica.plataforma_academica.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UnvaliableTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Teacher teacher;

    private LocalDateTime startTime;
    private LocalDateTime endDateTime;
    private String reason;
}

