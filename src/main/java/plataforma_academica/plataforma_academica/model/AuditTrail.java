package plataforma_academica.plataforma_academica.model;

import java.time.LocalDateTime;

public class AuditTrail {

    private User user;
    private String action;
    private String entifyAffected;
    private LocalDateTime timestamp;
}
