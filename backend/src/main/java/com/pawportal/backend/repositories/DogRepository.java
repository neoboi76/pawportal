package com.pawportal.backend.repositories;

import com.pawportal.backend.models.DogModel;
import com.pawportal.backend.models.enums.DogStatus;
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
 * Dog repository for database operations related to dogs
 *
 */

@Repository
public interface DogRepository extends JpaRepository<DogModel, Long> {

    List<DogModel> findByStatus(DogStatus status);

    List<DogModel> findByBreedContainingIgnoreCase(String breed);

}
