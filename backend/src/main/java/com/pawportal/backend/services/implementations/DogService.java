package com.pawportal.backend.services.implementations;

import com.pawportal.backend.models.DogModel;
import com.pawportal.backend.models.enums.DogStatus;
import com.pawportal.backend.repositories.DogRepository;
import com.pawportal.backend.services.interfaces.IDogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * DogService class. Deals with dog related service operations
 */

@Service
@RequiredArgsConstructor
public class DogService implements IDogService {

    private final DogRepository dogRepository;

    //Retrieves all dogs
    @Override
    public List<DogModel> getAllDogs() {
        return dogRepository.findAll();
    }

    //Retrieves a particular dog
    @Override
    public Optional<DogModel> getDogById(Long id) {
        return dogRepository.findById(id);
    }

    //Retrieves dogs according to status (used for filtering)
    @Override
    public List<DogModel> getDogsByStatus(DogStatus status) {
        return dogRepository.findByStatus(status);
    }

    //Creates a dog
    @Override
    public DogModel createDog(DogModel dog) {
        return dogRepository.save(dog);
    }

    //Updates dog information
    @Override
    public DogModel updateDog(Long id, DogModel dogDetails) {
        DogModel dog = dogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dog not found with id: " + id));

        dog.setName(dogDetails.getName());
        dog.setDescription(dogDetails.getDescription());
        dog.setBreed(dogDetails.getBreed());
        dog.setAge(dogDetails.getAge());
        dog.setSize(dogDetails.getSize());
        dog.setGender(dogDetails.getGender());
        dog.setImageUrl(dogDetails.getImageUrl());
        dog.setTemperament(dogDetails.getTemperament());
        dog.setVaccinated(dogDetails.getVaccinated());
        dog.setSpayedNeutered(dogDetails.getSpayedNeutered());
        dog.setStatus(dogDetails.getStatus());

        return dogRepository.save(dog);
    }

    //Deletes dog information
    @Override
    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }
}