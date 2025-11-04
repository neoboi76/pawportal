package com.pawportal.backend.repositories;

import com.pawportal.backend.models.ApplicationFormModel;
import com.pawportal.backend.models.enums.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationFormRepository extends JpaRepository<ApplicationFormModel, Long> {
    List<ApplicationFormModel> findByUserUserId(Long userId);
    List<ApplicationFormModel> findByStatus(ApplicationStatus status);
    List<ApplicationFormModel> findByDogDogId(Long dogId);
}

