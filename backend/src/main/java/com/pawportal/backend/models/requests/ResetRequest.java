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
 * DTO (Data Transfer Object) request class for reset password (from the settings) request.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResetRequest {

    private String email;
    private String oldPassword;
    private String newPassword;
    private String token;
}
