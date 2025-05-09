package plataforma_academica.plataforma_academica.services;

import plataforma_academica.plataforma_academica.model.AuditTrail;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditTrailService {
    AuditTrail logAction(AuditTrail auditTrail);
    List<AuditTrail> getAllAuditTrails();
    List<AuditTrail> getAuditTrailsByUser(Long userId);
    List<AuditTrail> getAuditTrailsByAction(String action);
    List<AuditTrail> getAuditTrailsByEntity(String entityAffected);
    List<AuditTrail> getAuditTrailsByDateRange(LocalDateTime start, LocalDateTime end);
}