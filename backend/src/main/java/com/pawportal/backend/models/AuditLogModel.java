package com.pawportal.backend.models;

import com.pawportal.backend.models.enums.AuditAction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Main entity class (table) for the internal Model representation.
 * of the audit logs
 */

@Entity
@Table(name = "audit_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogModel {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserModel user;

    //See Audit Action enum for full list of audit actions
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuditAction action;

    //Ip address is required
    @Column(nullable = false)
    private String ipAddress;

    private String userAgent;

    @Column(columnDefinition = "TEXT")
    private String details;

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();

    private Boolean success = true;

    @Column(columnDefinition = "TEXT")
    private String errorMessage;

}