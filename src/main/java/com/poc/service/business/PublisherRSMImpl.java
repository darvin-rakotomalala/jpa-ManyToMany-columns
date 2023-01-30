package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.Publisher;
import com.poc.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublisherRSMImpl implements PublisherRSM {

    private final PublisherRepository publisherRepository;

    @Override
    public Publisher getPublisherById(Long id) {
        try {
            log.info("----- getPublisherById : {}", id);
            Optional<Publisher> optionalPublisher = publisherRepository.findById(id);
            if (optionalPublisher.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_PUBLISHER_NOT_FOUND.getErrorMessage());
            }
            return optionalPublisher.get();
        } catch (Exception e) {
            log.error("Error getPublisherById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Page<Publisher> getAllPublishersByName(String name, Pageable pageable) {
        try {
            log.info("----- getAllPublishersByName : {}", name);
            if (StringUtils.isBlank(name)) {
                return publisherRepository.findAll(pageable);
            } else {
                return publisherRepository.findByNameContainingIgnoreCase(name, pageable);
            }
        } catch (Exception e) {
            log.error("Error getAllPublishersByName : {} {}", e.getMessage(), e);
            throw e;
        }
    }
}
