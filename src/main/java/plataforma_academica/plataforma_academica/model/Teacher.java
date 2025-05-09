package plataforma_academica.plataforma_academica.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeacherSchedule> availableSchedule;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UnvaliableTime> unavailableTimes;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;
}