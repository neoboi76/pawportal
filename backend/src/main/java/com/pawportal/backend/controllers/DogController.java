package com.pawportal.backend.controllers;

import com.pawportal.backend.models.DogModel;
import com.pawportal.backend.models.enums.DogStatus;
import com.pawportal.backend.services.interfaces.IDogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dogs")
@RequiredArgsConstructor
public class DogController {

    private final IDogService dogService;

    @GetMapping
    public ResponseEntity<List<DogModel>> getAllDogs() {
        return ResponseEntity.ok(dogService.getAllDogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DogModel> getDogById(@PathVariable Long id) {
        return dogService.getDogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<DogModel>> getDogsByStatus(@PathVariable String status) {
        DogStatus dogStatus = DogStatus.valueOf(status.toUpperCase());
        return ResponseEntity.ok(dogService.getDogsByStatus(dogStatus));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DogModel> createDog(@RequestBody DogModel dog) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dogService.createDog(dog));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DogModel> updateDog(@PathVariable Long id, @RequestBody DogModel dog) {
        return ResponseEntity.ok(dogService.updateDog(id, dog));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
        return ResponseEntity.noContent().build();
    }
}
