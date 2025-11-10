package com.pawportal.backend.repositories;

import com.pawportal.backend.models.TokenBlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.Instant;
import java.util.Optional;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Token repository for database operations related
 * storing and managing JWT tokens
 */

@Repository
public interface TokenRepository extends JpaRepository<TokenBlackList, Long> {

    boolean existsByToken(String token);

    void deleteByExpiryDateBefore(Instant now);

    Optional<TokenBlackList> findByToken(String token);
}