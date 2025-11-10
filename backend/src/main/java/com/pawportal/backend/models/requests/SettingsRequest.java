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
 * DTO (Data Transfer Object) request class settings form equest.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SettingsRequest {
    private String email;
    private String firstName;
    private String lastName;
    private Long id;
    private String mobileNumber;
    private String gender;
    private String country;
    private String language;
}
