package plataforma_academica.plataforma_academica.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma_academica.plataforma_academica.model.SubjectSchedule;
import plataforma_academica.plataforma_academica.repositories.SubjectScheduleRepository;

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

    @Service
    @RequiredArgsConstructor
    class SubjectScheduleServiceImpl implements SubjectScheduleService {

        private final SubjectScheduleRepository scheduleRepository;

        @Override
        public SubjectSchedule createSchedule(SubjectSchedule schedule) {
            if (hasTimeConflict(schedule.getSubject().getId(), schedule.getDayOfWeek(),
                    schedule.getStartTime(), schedule.getEndTime())) {
                throw new IllegalArgumentException("Conflicto de horario detectado");
            }
            return scheduleRepository.save(schedule);
        }

        @Override
        public SubjectSchedule updateSchedule(Long id, SubjectSchedule schedule) {
            schedule.setId(id);
            return scheduleRepository.save(schedule);
        }

        @Override
        public void deleteSchedule(Long id) {
            scheduleRepository.deleteById(id);
        }

        @Override
        public SubjectSchedule getScheduleById(Long id) {
            return scheduleRepository.findById(id).orElse(null);
        }

        @Override
        public List<SubjectSchedule> getAllSchedules() {
            return scheduleRepository.findAll();
        }

        @Override
        public List<SubjectSchedule> getSchedulesBySubject(Long subjectId) {
            return scheduleRepository.findBySubjectId(subjectId);
        }

        @Override
        public List<SubjectSchedule> getSchedulesByDay(DayOfWeek day) {
            return scheduleRepository.findByDayOfWeek(day);
        }

        @Override
        public List<SubjectSchedule> getSchedulesBySubjectAndDay(Long subjectId, DayOfWeek day) {
            return scheduleRepository.findBySubjectAndDay(subjectId, day);
        }

        @Override
        public boolean hasTimeConflict(Long subjectId, DayOfWeek day, LocalTime start, LocalTime end) {
            List<SubjectSchedule> existingSchedules = scheduleRepository.findBySubjectAndDay(subjectId, day);

            return existingSchedules.stream().anyMatch(schedule ->
                    start.isBefore(schedule.getEndTime()) && end.isAfter(schedule.getStartTime()));

        }
    }
}