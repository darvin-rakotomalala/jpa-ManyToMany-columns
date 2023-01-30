package com.poc.service.business;

import com.poc.model.domain.Publisher;
import com.poc.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublisherCUDSMImpl implements PublisherCUDSM {

    private final PublisherRepository publisherRepository;
    private final PublisherRSM publisherRSM;

    @Override
    public Publisher createOrUpdatePublisher(Publisher publisher) {
        try {
            log.info("----- createOrUpdatePublisher");
            return publisherRepository.save(publisher);
        } catch (Exception e) {
            log.error("Error createOrUpdatePublisher : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Publisher> saveAllPublishers(List<Publisher> publishers) {
        try {
            log.info("----- saveAllPublishers");
            return publisherRepository.saveAll(publishers);
        } catch (Exception e) {
            log.error("Error saveAllPublishers : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deletePublisherById(Long id) {
        try {
            log.info("----- deletePublisherById : {}", id);
            Publisher publisherFound = publisherRSM.getPublisherById(id);
            publisherRepository.deleteById(publisherFound.getId());
        } catch (Exception e) {
            log.error("Error deletePublisherById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
