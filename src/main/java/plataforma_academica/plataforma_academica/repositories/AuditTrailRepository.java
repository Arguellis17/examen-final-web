package plataforma_academica.plataforma_academica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plataforma_academica.plataforma_academica.model.AuditTrail;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditTrailRepository extends JpaRepository<AuditTrail, Long> {
    List<AuditTrail> findByUser_Id(Long userId);
    List<AuditTrail> findByAction(String action);
    List<AuditTrail> findByEntityAffected(String entityAffected);
    List<AuditTrail> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}