package com.pawportal.backend.services.interfaces;

import com.pawportal.backend.models.responses.UserResponse;

import java.util.List;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Interface class for the UserService. Promotes Dependency Injection
 * and loosely coupled relationships.
 */

public interface IUserService {

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse suspendUser(Long id);

    UserResponse activateUser(Long id);

    UserResponse promoteUser(Long id);

    void deleteUser(Long id);
}