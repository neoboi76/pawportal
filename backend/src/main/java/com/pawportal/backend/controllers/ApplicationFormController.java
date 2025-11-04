package com.pawportal.backend.controllers;

import com.pawportal.backend.models.ApplicationFormModel;
import com.pawportal.backend.services.interfaces.IApplicationFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationFormController {

    private final IApplicationFormService applicationFormService;

    @PostMapping
    public ResponseEntity<ApplicationFormModel> createApplication(@RequestBody ApplicationFormModel application) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationFormService.createApplication(application));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ApplicationFormModel>> getAllApplications() {
        return ResponseEntity.ok(applicationFormService.getAllApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationFormModel> getApplicationById(@PathVariable Long id) {
        return applicationFormService.getApplicationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ApplicationFormModel>> getApplicationsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(applicationFormService.getApplicationsByUserId(userId));
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApplicationFormModel> updateApplicationStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(applicationFormService.updateApplicationStatus(id, status));
    }
}