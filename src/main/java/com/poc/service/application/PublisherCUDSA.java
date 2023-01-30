package com.poc.service.application;

import com.poc.model.dto.PublisherDTO;

import java.util.List;

public interface PublisherCUDSA {
    public PublisherDTO createPublisher(PublisherDTO publisherDTO);
    public List<PublisherDTO> saveAllPublishers(List<PublisherDTO> publisherDTOs);
    public PublisherDTO updatePublisher(PublisherDTO publisherDTO);
    public void deletePublisherById(Long id);
}
