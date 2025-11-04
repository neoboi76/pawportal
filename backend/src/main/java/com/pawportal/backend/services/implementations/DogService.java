package com.pawportal.backend.services.implementations;

import com.pawportal.backend.models.DogModel;
import com.pawportal.backend.models.enums.DogStatus;
import com.pawportal.backend.repositories.DogRepository;
import com.pawportal.backend.services.interfaces.IDogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogService implements IDogService {

    private final DogRepository dogRepository;

    @Override
    public List<DogModel> getAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public Optional<DogModel> getDogById(Long id) {
        return dogRepository.findById(id);
    }

    @Override
    public List<DogModel> getDogsByStatus(DogStatus status) {
        return dogRepository.findByStatus(status);
    }

    @Override
    public DogModel createDog(DogModel dog) {
        return dogRepository.save(dog);
    }

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

    @Override
    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }
}