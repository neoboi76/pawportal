package com.pawportal.backend.services.implementations;

import com.pawportal.backend.models.AuditLogModel;
import com.pawportal.backend.models.UserModel;
import com.pawportal.backend.models.enums.AuditAction;
import com.pawportal.backend.models.responses.AuditLogResponse;
import com.pawportal.backend.repositories.AuditLogRepository;
import com.pawportal.backend.repositories.UserRepository;
import com.pawportal.backend.services.interfaces.IAuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * AuditLogService class. Deals with audit logs related service operations
 */

@Service
@RequiredArgsConstructor
public class AuditLogService implements IAuditLogService {

    private final AuditLogRepository auditLogRepository;
    private final UserRepository userRepository;

    //Logs action
    //Function overloading
    //Transactional means that multiple db operations are treated as a single
    //Transaction. If one of the operations fail, the whole process is "rolled back",
    //and the operations abrupt, as if it didn't happen at all
    @Override
    @Transactional
    public void logAction(UserModel user, AuditAction action, String ipAddress, String userAgent, String details) {
        AuditLogModel auditLog = new AuditLogModel();
        auditLog.setUser(user);
        auditLog.setAction(action);
        auditLog.setIpAddress(ipAddress != null ? ipAddress : "Unknown");
        auditLog.setUserAgent(userAgent);
        auditLog.setDetails(details);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLog.setSuccess(true);
        auditLogRepository.save(auditLog);
    }

    //Logs action
    //Function overloading
    @Override
    @Transactional
    public void logAction(Long userId, AuditAction action, String ipAddress, String userAgent, String details) {
        UserModel user = userId != null ? userRepository.findById(userId).orElse(null) : null;
        AuditLogModel auditLog = new AuditLogModel();
        auditLog.setUser(user);
        auditLog.setAction(action);
        auditLog.setIpAddress(ipAddress != null ? ipAddress : "Unknown");
        auditLog.setUserAgent(userAgent);
        auditLog.setDetails(details);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLog.setSuccess(true);
        auditLogRepository.save(auditLog);
    }

    //Logs action with error
    @Override
    @Transactional
    public void logActionWithError(UserModel user, AuditAction action, String ipAddress, String userAgent, String details, String errorMessage) {
        AuditLogModel auditLog = new AuditLogModel();
        auditLog.setUser(user);
        auditLog.setAction(action);
        auditLog.setIpAddress(ipAddress != null ? ipAddress : "Unknown");
        auditLog.setUserAgent(userAgent);
        auditLog.setDetails(details);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLog.setSuccess(false);
        auditLog.setErrorMessage(errorMessage);
        auditLogRepository.save(auditLog);
    }

    //Retrieves all audit logs
    @Override
    public List<AuditLogResponse> getAllAuditLogs() {
        return auditLogRepository.findAll().stream()
                .map(this::convertToAuditLogResponse)
                .collect(Collectors.toList());
    }

    //Retrieves all audit logs of a particular user
    @Override
    public List<AuditLogModel> getAuditLogsByUserId(Long userId) {
        return auditLogRepository.findByUserUserId(userId);
    }

    //Retrieves all audit logs by action (used for filtering)
    @Override
    public List<AuditLogModel> getAuditLogsByAction(AuditAction action) {
        return auditLogRepository.findByAction(action);
    }

    //Retrieves most recent audit logs
    @Override
    public List<AuditLogModel> getRecentAuditLogs(int limit) {
        List<AuditLogModel> logs = auditLogRepository.findTop100ByOrderByTimestampDesc();
        return logs.size() > limit ? logs.subList(0, limit) : logs;
    }

    //Converts response to proper DTO response object
    private AuditLogResponse convertToAuditLogResponse(AuditLogModel auditLog) {
        AuditLogResponse response = new AuditLogResponse();
        response.setAuditId(auditLog.getAuditId());

        if (auditLog.getUser() != null) {
            AuditLogResponse.UserAuditInfo userInfo = new AuditLogResponse.UserAuditInfo();
            userInfo.setUserId(auditLog.getUser().getUserId());
            userInfo.setEmail(auditLog.getUser().getEmail());
            userInfo.setFirstName(auditLog.getUser().getFirstName());
            userInfo.setLastName(auditLog.getUser().getLastName());
            response.setUser(userInfo);
        }

        response.setAction(auditLog.getAction());
        response.setIpAddress(auditLog.getIpAddress());
        response.setUserAgent(auditLog.getUserAgent());
        response.setDetails(auditLog.getDetails());
        response.setTimestamp(auditLog.getTimestamp());
        response.setSuccess(auditLog.getSuccess());
        response.setErrorMessage(auditLog.getErrorMessage());

        return response;
    }
}