package com.pawportal.backend.services.implementations;

import com.pawportal.backend.models.ContactFormModel;
import com.pawportal.backend.repositories.ContactFormRepository;
import com.pawportal.backend.services.interfaces.IContactFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * ContactFormService class. Deals with contact forms related service operations
 */

@Service
@RequiredArgsConstructor
public class ContactFormService implements IContactFormService {

    private final ContactFormRepository contactFormRepository;

    //Creates Contact forms
    @Override
    public ContactFormModel createContactForm(ContactFormModel contactForm) {
        return contactFormRepository.save(contactForm);
    }

    //Retrieves all contact forms
    @Override
    public List<ContactFormModel> getAllContactForms() {
        return contactFormRepository.findAll();
    }
}
