package com.pawportal.backend.models;

import com.pawportal.backend.models.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "application_forms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationFormModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dogId")
    private DogModel dog;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String postalCode;

    @Column(columnDefinition = "TEXT")
    private String occupation;

    @Column(columnDefinition = "TEXT")
    private String livingStatus;

    @Column(columnDefinition = "TEXT")
    private String reasonForAdoption;

    @Column(columnDefinition = "TEXT")
    private String experience;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status = ApplicationStatus.PENDING;

    @Column(nullable = false, updatable = false)
    private LocalDateTime submittedAt = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String adminNotes;
}