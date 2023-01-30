package com.poc.service.business;

import com.poc.model.domain.Publisher;

import java.util.List;

public interface PublisherCUDSM {
    public Publisher createOrUpdatePublisher(Publisher publisher);
    public List<Publisher> saveAllPublishers(List<Publisher> publishers);
    public void deletePublisherById(Long id);
}
