package plataforma_academica.plataforma_academica.model;

import java.util.List;

public class Subject {

    private String title;
    private Teacher teacher;
    private List<Student> students;
    private List<SubjectSchedule> schedules;
    private List<Evaluation> evaluations;
}
