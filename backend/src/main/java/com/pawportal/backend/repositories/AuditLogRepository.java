package com.pawportal.backend.repositories;

import com.pawportal.backend.models.AuditLogModel;
import com.pawportal.backend.models.enums.AuditAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Audit log repository for database operations related to the
 * audit logs
 */

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLogModel, Long> {

    List<AuditLogModel> findByUserUserId(Long userId);

    List<AuditLogModel> findByAction(AuditAction action);

    List<AuditLogModel> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    List<AuditLogModel> findTop100ByOrderByTimestampDesc();
}