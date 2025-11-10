package com.pawportal.backend.services.implementations;

import com.pawportal.backend.models.TokenBlackList;
import com.pawportal.backend.repositories.TokenRepository;
import com.pawportal.backend.services.interfaces.ILogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Date;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Logout service class. Deals with logging out a user by blacklisting
 * their JWT token
 */

@Service
@RequiredArgsConstructor
public class LogoutService implements ILogoutService {

    private final TokenRepository tokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    //Blacklists the JWT token
    @Override
    public void blacklistToken(String token) {
        if (token != null) {
            Date expiryDate = jwtTokenProvider.getExpirationDateFromToken(token);
            TokenBlackList blacklistedToken = new TokenBlackList(token, expiryDate.toInstant());
            tokenRepository.save(blacklistedToken);
        }
    }

    //Determines if JWT token was already blacklisted
    @Override
    public boolean isTokenBlacklisted(String token) {
        return tokenRepository.existsByToken(token);
    }

    //Purge JWT tokens longer than 24 hours
    @Override
    @Scheduled(fixedRate = 3600000)
    public void purgeExpiredTokens() {
        tokenRepository.deleteByExpiryDateBefore(Instant.now());
    }
}