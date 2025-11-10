package com.pawportal.backend.repositories;

import com.pawportal.backend.models.ApplicationFormModel;
import com.pawportal.backend.models.enums.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Application form repository for database operations related to the
 * application forms
 */

@Repository
public interface ApplicationFormRepository extends JpaRepository<ApplicationFormModel, Long> {
    List<ApplicationFormModel> findByUserUserId(Long userId);

    List<ApplicationFormModel> findByStatus(ApplicationStatus status);

    List<ApplicationFormModel> findByDogDogId(Long dogId);
}

