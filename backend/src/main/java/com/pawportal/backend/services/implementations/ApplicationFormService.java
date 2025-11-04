package com.pawportal.backend.services.implementations;

import com.pawportal.backend.models.ApplicationFormModel;
import com.pawportal.backend.models.enums.ApplicationStatus;
import com.pawportal.backend.repositories.ApplicationFormRepository;
import com.pawportal.backend.services.interfaces.IApplicationFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationFormService implements IApplicationFormService {

    private final ApplicationFormRepository applicationFormRepository;

    @Override
    public ApplicationFormModel createApplication(ApplicationFormModel application) {
        return applicationFormRepository.save(application);
    }

    @Override
    public List<ApplicationFormModel> getAllApplications() {
        return applicationFormRepository.findAll();
    }

    @Override
    public Optional<ApplicationFormModel> getApplicationById(Long id) {
        return applicationFormRepository.findById(id);
    }

    @Override
    public List<ApplicationFormModel> getApplicationsByUserId(Long userId) {
        return applicationFormRepository.findByUserUserId(userId);
    }

    @Override
    public ApplicationFormModel updateApplicationStatus(Long id, String statusStr) {
        ApplicationFormModel application = applicationFormRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        ApplicationStatus status = ApplicationStatus.valueOf(statusStr.toUpperCase());
        application.setStatus(status);
        return applicationFormRepository.save(application);
    }
}
