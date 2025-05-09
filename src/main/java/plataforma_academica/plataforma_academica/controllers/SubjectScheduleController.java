package plataforma_academica.plataforma_academica.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plataforma_academica.plataforma_academica.model.SubjectSchedule;
import plataforma_academica.plataforma_academica.services.SubjectScheduleService;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/subject-schedules")
@RequiredArgsConstructor
public class SubjectScheduleController {

    private final SubjectScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<SubjectSchedule> createSchedule(@RequestBody SubjectSchedule schedule) {
        return ResponseEntity.ok(scheduleService.createSchedule(schedule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectSchedule> updateSchedule(
            @PathVariable Long id,
            @RequestBody SubjectSchedule schedule) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectSchedule> getScheduleById(@PathVariable Long id) {
        SubjectSchedule schedule = scheduleService.getScheduleById(id);
        return schedule != null ? ResponseEntity.ok(schedule) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<SubjectSchedule>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<SubjectSchedule>> getSchedulesBySubject(
            @PathVariable Long subjectId) {
        return ResponseEntity.ok(scheduleService.getSchedulesBySubject(subjectId));
    }

    @GetMapping("/day/{day}")
    public ResponseEntity<List<SubjectSchedule>> getSchedulesByDay(
            @PathVariable DayOfWeek day) {
        return ResponseEntity.ok(scheduleService.getSchedulesByDay(day));
    }

    @GetMapping("/conflict-check")
    public ResponseEntity<Boolean> checkTimeConflict(
            @RequestParam Long subjectId,
            @RequestParam DayOfWeek day,
            @RequestParam String startTime,
            @RequestParam String endTime) {
        return ResponseEntity.ok(scheduleService.hasTimeConflict(
                subjectId, day, LocalTime.parse(startTime), LocalTime.parse(endTime)));
    }
}