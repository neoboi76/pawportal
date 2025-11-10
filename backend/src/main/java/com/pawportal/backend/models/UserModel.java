package com.pawportal.backend.models;

import com.pawportal.backend.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
 * Main entity class (table) for the internal Model representation.
 * of the user
 */

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false, unique = true)
    private String email;

    //Password stored as BCrypt Hashed, not plaintext!
    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    //Optional
    private String mobileNumber;

    //Optional
    private String gender;

    //Optional
    private String country;

    //Optional
    private String language;

    //Either admin or user
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    //Used to determine whether a user is suspended
    //or not (if suspended, user cannot log in).
    @Column(nullable = false)
    private Boolean suspended = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    //A user can have many audit logs. If user is deleted,
    //all audit logs associated with that user is deleted as well.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AuditLogModel> auditLogs;

    //A user can have many audit logs. If user is deleted,
    //all audit logs associated with that user is deleted as well.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ApplicationFormModel> applications;
}