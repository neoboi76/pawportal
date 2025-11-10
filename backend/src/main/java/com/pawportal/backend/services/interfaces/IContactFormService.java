package com.pawportal.backend.services.interfaces;

import com.pawportal.backend.models.ContactFormModel;
import java.util.List;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Interface class for the ContactFormService. Promotes Dependency Injection
 * and loosely coupled relationships.
 */

public interface IContactFormService {

    ContactFormModel createContactForm(ContactFormModel contactForm);

    List<ContactFormModel> getAllContactForms();

}
