package com.pawportal.backend.services.interfaces;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Interface class for the EmailService (ForgotService). Promotes Dependency Injection
 * and loosely coupled relationships.
 */

public interface IEmailService {

    public void sendResetPasswordEmail(String toEmail, String token);

}
