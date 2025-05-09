package plataforma_academica.plataforma_academica.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plataforma_academica.plataforma_academica.model.Evaluation;
import plataforma_academica.plataforma_academica.services.EvaluationService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @GetMapping
    public List<Evaluation> getAllEvaluations() {
        return evaluationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable Long id) {
        Evaluation evaluation = evaluationService.findById(id);
        return evaluation != null ? ResponseEntity.ok(evaluation) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationService.save(evaluation);
    }

    @PutMapping("/{id}")
    public Evaluation updateEvaluation(@PathVariable Long id, @RequestBody Evaluation evaluation) {
        return evaluationService.update(id, evaluation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        evaluationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/title")
    public List<Evaluation> searchByTitle(@RequestParam String title) {
        return evaluationService.findByTitle(title);
    }

    @GetMapping("/search/subject")
    public List<Evaluation> searchBySubject(@RequestParam Long subjectId) {
        return evaluationService.findBySubject(subjectId);
    }

    @GetMapping("/search/date-range")
    public List<Evaluation> searchByDateRange(
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        return evaluationService.findByDateRange(startDate, endDate);
    }
}