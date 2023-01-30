package com.poc.service.business;

import com.poc.model.domain.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PublisherRSM {
    public Publisher getPublisherById(Long id);
    public Page<Publisher> getAllPublishersByName(String name, Pageable pageable);
}
