package com.pawportal.backend.models;

import com.pawportal.backend.models.enums.DogSize;
import com.pawportal.backend.models.enums.DogStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "dogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dogId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String breed;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private DogSize size;

    private String gender;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String temperament;

    private Boolean vaccinated = true;

    private Boolean spayedNeutered = false;

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