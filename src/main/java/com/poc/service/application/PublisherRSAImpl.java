package com.poc.service.application;

import com.poc.mapper.PublisherMapper;
import com.poc.model.dto.PublisherDTO;
import com.poc.service.business.PublisherRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PublisherRSAImpl implements PublisherRSA {

    private final PublisherRSM publisherRSM;
    private final PublisherMapper publisherMapper;

    @Override
    public PublisherDTO getPublisherById(Long id) {
        return publisherMapper.toDTO(publisherRSM.getPublisherById(id));
    }

    @Override
    public HelpPage<PublisherDTO> getAllPublishersByName(String name, Pageable pageable) {
        return publisherMapper.toDTO(publisherRSM.getAllPublishersByName(name, pageable), pageable);
    }

}
