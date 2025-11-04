package com.pawportal.backend.repositories;


import com.pawportal.backend.models.DogModel;
import com.pawportal.backend.models.enums.DogStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<DogModel, Long> {
    List<DogModel> findByStatus(DogStatus status);
    List<DogModel> findByBreedContainingIgnoreCase(String breed);
}
