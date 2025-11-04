package com.pawportal.backend.services.interfaces;

import com.pawportal.backend.models.DogModel;
import com.pawportal.backend.models.enums.DogStatus;

import java.util.List;
import java.util.Optional;

public interface IDogService {
    List<DogModel> getAllDogs();
    Optional<DogModel> getDogById(Long id);
    List<DogModel> getDogsByStatus(DogStatus status);
    DogModel createDog(DogModel dog);
    DogModel updateDog(Long id, DogModel dog);
    void deleteDog(Long id);
}

