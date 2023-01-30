package com.poc.service.application;

import com.poc.model.dto.PublisherDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

public interface PublisherRSA {
    public PublisherDTO getPublisherById(Long id);
    public HelpPage<PublisherDTO> getAllPublishersByName(String name, Pageable pageable);
}
