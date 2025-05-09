package plataforma_academica.plataforma_academica.services;

import plataforma_academica.plataforma_academica.model.SubjectSchedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface SubjectScheduleService {
    SubjectSchedule createSchedule(SubjectSchedule schedule);
    SubjectSchedule updateSchedule(Long id, SubjectSchedule schedule);
    void deleteSchedule(Long id);
    SubjectSchedule getScheduleById(Long id);
    List<SubjectSchedule> getAllSchedules();
    List<SubjectSchedule> getSchedulesBySubject(Long subjectId);
    List<SubjectSchedule> getSchedulesByDay(DayOfWeek day);
    List<SubjectSchedule> getSchedulesBySubjectAndDay(Long subjectId, DayOfWeek day);
    boolean hasTimeConflict(Long subjectId, DayOfWeek day, LocalTime start, LocalTime end);
}