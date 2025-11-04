package com.pawportal.backend.repositories;

import com.pawportal.backend.models.ContactFormModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactFormModel, Long> {
    List<ContactFormModel> findByResponded(Boolean responded);
}