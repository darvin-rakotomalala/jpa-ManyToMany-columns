package com.poc.repository;

import com.poc.model.domain.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Page<Publisher> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
