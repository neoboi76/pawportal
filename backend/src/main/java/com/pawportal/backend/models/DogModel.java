package com.pawportal.backend.models;

import com.pawportal.backend.models.enums.DogSize;
import com.pawportal.backend.models.enums.DogStatus;
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
 * of the dogs
 */

@Entity
@Table(name = "dogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogModel {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dogId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String breed;

    private Integer age;

    //Sizes are SMALL, MEDIUM, LARGE, and EXTRA_LARGE
    @Enumerated(EnumType.STRING)
    private DogSize size;

    private String gender;

    //Stores web url for the image
    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String temperament;

    private Boolean vaccinated = true;

    private Boolean spayedNeutered = false;

    //Statuses are AVAILABLE, ADOPTED, or PENDING
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DogStatus status = DogStatus.AVAILABLE;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}