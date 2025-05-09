package plataforma_academica.plataforma_academica.model;

import java.util.List;

public class Teacher extends User {

    private List<TeacherSchedule> avaliableSchedule;
    private List<UnvaliableTime> unvaliableTimes;
    private List<Subjects> subjects;
}
