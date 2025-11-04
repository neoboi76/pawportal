package com.pawportal.backend.services.interfaces;

import com.pawportal.backend.models.ContactFormModel;
import java.util.List;

public interface IContactFormService {
    ContactFormModel createContactForm(ContactFormModel contactForm);
    List<ContactFormModel> getAllContactForms();
}
