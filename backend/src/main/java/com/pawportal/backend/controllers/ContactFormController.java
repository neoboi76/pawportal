package com.pawportal.backend.controllers;

import com.pawportal.backend.models.ContactFormModel;
import com.pawportal.backend.services.interfaces.IContactFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactFormController {

    private final IContactFormService contactFormService;

    @PostMapping
    public ResponseEntity<ContactFormModel> createContactForm(@RequestBody ContactFormModel contactForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactFormService.createContactForm(contactForm));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ContactFormModel>> getAllContactForms() {
        return ResponseEntity.ok(contactFormService.getAllContactForms());
    }
}