package plataforma_academica.plataforma_academica.model;

import javax.security.auth.Subject;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class SubjectSchedule {

    private Subject subject;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
