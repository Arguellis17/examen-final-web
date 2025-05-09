package plataforma_academica.plataforma_academica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import plataforma_academica.plataforma_academica.model.SubjectSchedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface SubjectScheduleRepository extends JpaRepository<SubjectSchedule, Long> {
    List<SubjectSchedule> findBySubjectId(Long subjectId);
    List<SubjectSchedule> findByDayOfWeek(DayOfWeek dayOfWeek);

    @Query("SELECT ss FROM SubjectSchedule ss WHERE ss.subject.id = :subjectId AND ss.dayOfWeek = :day")
    List<SubjectSchedule> findBySubjectAndDay(@Param("subjectId") Long subjectId,
                                              @Param("day") DayOfWeek day);

    @Query("SELECT ss FROM SubjectSchedule ss WHERE ss.startTime <= :time AND ss.endTime >= :time AND ss.dayOfWeek = :day")
    List<SubjectSchedule> findSchedulesAtTime(@Param("day") DayOfWeek day,
                                              @Param("time") LocalTime time);
}