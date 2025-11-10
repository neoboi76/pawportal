package com.pawportal.backend.repositories;

import com.pawportal.backend.models.ContactFormModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Developed by Group 6:
 * Kenji Mark Alan Arceo
 * Carl Norbi Felonia
 * Ryonan Owen Ferrer
 * Dino Alfred Timbol
 * Mike Emil Vocal
 */

/**
 * Contact forms repository for database operations related to the
 * contact forms
 */

@Repository
public interface ContactFormRepository extends JpaRepository<ContactFormModel, Long> {

    List<ContactFormModel> findByResponded(Boolean responded);

}