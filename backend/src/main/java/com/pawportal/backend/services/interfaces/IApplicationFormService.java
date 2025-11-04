package com.pawportal.backend.services.interfaces;

import com.pawportal.backend.models.ApplicationFormModel;
import java.util.List;
import java.util.Optional;

public interface IApplicationFormService {
    ApplicationFormModel createApplication(ApplicationFormModel application);
    List<ApplicationFormModel> getAllApplications();
    Optional<ApplicationFormModel> getApplicationById(Long id);
    List<ApplicationFormModel> getApplicationsByUserId(Long userId);
    ApplicationFormModel updateApplicationStatus(Long id, String status);
}

