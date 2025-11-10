package com.pawportal.backend.repositories;

import com.pawportal.backend.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * User repository for database operations related to users
 *
 */

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);

    Optional<UserModel> findById(long id);

    //Custom JPQL (Java Persistence Query Language) query.
    //Find user id by user email
    @Query("SELECT u.userId FROM UserModel u WHERE u.email = :email")
    Long getUserIdByEmail(@Param("email") String email);

    boolean existsByEmail(String email);
}
