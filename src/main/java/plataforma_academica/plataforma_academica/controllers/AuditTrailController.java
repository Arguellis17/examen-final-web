package plataforma_academica.plataforma_academica.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plataforma_academica.plataforma_academica.model.AuditTrail;
import plataforma_academica.plataforma_academica.services.AuditTrailService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/audit-trail")
@RequiredArgsConstructor
public class AuditTrailController {

    private final AuditTrailService auditTrailService;

    @PostMapping
    public ResponseEntity<AuditTrail> logAction(@RequestBody AuditTrail auditTrail) {
        return ResponseEntity.ok(auditTrailService.logAction(auditTrail));
    }

    @GetMapping
    public ResponseEntity<List<AuditTrail>> getAllAuditTrails() {
        return ResponseEntity.ok(auditTrailService.getAllAuditTrails());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AuditTrail>> getAuditTrailsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(auditTrailService.getAuditTrailsByUser(userId));
    }

    @GetMapping("/action/{action}")
    public ResponseEntity<List<AuditTrail>> getAuditTrailsByAction(@PathVariable String action) {
        return ResponseEntity.ok(auditTrailService.getAuditTrailsByAction(action));
    }

    @GetMapping("/entity/{entity}")
    public ResponseEntity<List<AuditTrail>> getAuditTrailsByEntity(@PathVariable String entity) {
        return ResponseEntity.ok(auditTrailService.getAuditTrailsByEntity(entity));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<AuditTrail>> getAuditTrailsByDateRange(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return ResponseEntity.ok(auditTrailService.getAuditTrailsByDateRange(start, end));
    }
}