package com.pawportal.backend.services.implementations;

import com.pawportal.backend.models.ContactFormModel;
import com.pawportal.backend.repositories.ContactFormRepository;
import com.pawportal.backend.services.interfaces.IContactFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactFormService implements IContactFormService {

    private final ContactFormRepository contactFormRepository;

    @Override
    public ContactFormModel createContactForm(ContactFormModel contactForm) {
        return contactFormRepository.save(contactForm);
    }

    @Override
    public List<ContactFormModel> getAllContactForms() {
        return contactFormRepository.findAll();
    }
}
