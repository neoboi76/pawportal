package com.pawportal.backend.services.interfaces;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Interface class for the LogoutService. Promotes Dependency Injection
 * and loosely coupled relationships.
 */

public interface ILogoutService {

    void blacklistToken(String token);

    boolean isTokenBlacklisted(String token);

    void purgeExpiredTokens();

}
