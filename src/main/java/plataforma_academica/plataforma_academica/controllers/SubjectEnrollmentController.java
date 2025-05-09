package plataforma_academica.plataforma_academica.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plataforma_academica.plataforma_academica.model.SubjectEnrollment;
import plataforma_academica.plataforma_academica.services.SubjectEnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class SubjectEnrollmentController {

    private final SubjectEnrollmentService service;

    @GetMapping
    public ResponseEntity<List<SubjectEnrollment>> getAll() {
        return ResponseEntity.ok(service.getAllEnrollments());
    }

    @GetMapping("/{studentId}/{subjectId}")
    public ResponseEntity<SubjectEnrollment> getByIds(@PathVariable Long studentId, @PathVariable Long subjectId) {
        return service.getEnrollment(studentId, subjectId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SubjectEnrollment> enroll(@RequestBody SubjectEnrollment enrollment) {
        return ResponseEntity.ok(service.enrollStudent(enrollment));
    }

    @DeleteMapping("/{studentId}/{subjectId}")
    public ResponseEntity<Void> delete(@PathVariable Long studentId, @PathVariable Long subjectId) {
        service.deleteEnrollment(studentId, subjectId);
        return ResponseEntity.noContent().build();
    }
}
