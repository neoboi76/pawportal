package com.pawportal.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Main entity class (table) for the internal Model representation.
 * of JWT token blacklisting process
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenBlackList {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //JWT Token cannot be null
    @Column(nullable = false, unique = true, length = 512)
    private String token;

    //Expiry date
    @Column(nullable = false)
    private Instant expiryDate;

    public TokenBlackList(String token, Instant expiryDate) {
        this.token = token;
        this.expiryDate = expiryDate;
    }
}