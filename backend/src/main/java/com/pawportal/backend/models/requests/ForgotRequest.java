package com.pawportal.backend.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * DTO (Data Transfer Object) request clas forgot password (from the login page) form request.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotRequest{
    private String email;
    private String newPassword;
    private String token;
}