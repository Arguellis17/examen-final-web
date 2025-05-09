package plataforma_academica.plataforma_academica.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma_academica.plataforma_academica.model.AuditTrail;
import plataforma_academica.plataforma_academica.repositories.AuditTrailRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditTrailServiceImpl implements AuditTrailService {

    private final AuditTrailRepository auditTrailRepository;

    @Override
    public AuditTrail logAction(AuditTrail auditTrail) {
        return auditTrailRepository.save(auditTrail);
    }

    @Override
    public List<AuditTrail> getAllAuditTrails() {
        return auditTrailRepository.findAll();
    }

    @Override
    public List<AuditTrail> getAuditTrailsByUser(Long userId) {
        return auditTrailRepository.findByUser_Id(userId);
    }

    @Override
    public List<AuditTrail> getAuditTrailsByAction(String action) {
        return auditTrailRepository.findByAction(action);
    }

    @Override
    public List<AuditTrail> getAuditTrailsByEntity(String entityAffected) {
        return auditTrailRepository.findByEntityAffected(entityAffected);
    }

    @Override
    public List<AuditTrail> getAuditTrailsByDateRange(LocalDateTime start, LocalDateTime end) {
        return auditTrailRepository.findByTimestampBetween(start, end);
    }
}