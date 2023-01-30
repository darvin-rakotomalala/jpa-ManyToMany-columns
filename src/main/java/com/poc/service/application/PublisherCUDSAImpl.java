package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.mapper.PublisherMapper;
import com.poc.model.dto.PublisherDTO;
import com.poc.service.business.PublisherCUDSM;
import com.poc.service.business.PublisherRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PublisherCUDSAImpl implements PublisherCUDSA {

    private final PublisherCUDSM publisherCUDSM;
    private final PublisherRSM publisherRSM;
    private final PublisherMapper publisherMapper;

    @Override
    public PublisherDTO createPublisher(PublisherDTO publisherDTO) {
        if (publisherDTO == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_PUBLISHER_OBJECT_EMPTY.getErrorMessage());
        }
        return publisherMapper.toDTO(publisherCUDSM.createOrUpdatePublisher(publisherMapper.toDO(publisherDTO)));
    }

    @Override
    public List<PublisherDTO> saveAllPublishers(List<PublisherDTO> publisherDTOs) {
        return publisherMapper.toDTO(publisherCUDSM.saveAllPublishers(publisherMapper.toDO(publisherDTOs)));
    }

    @Override
    public PublisherDTO updatePublisher(PublisherDTO publisherDTO) {
        if (publisherDTO == null || publisherDTO.getId() == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_PUBLISHER_OBJECT_EMPTY.getErrorMessage());
        }
        PublisherDTO publisherFound = publisherMapper.toDTO(publisherRSM.getPublisherById(publisherDTO.getId()));
        publisherFound.setName(publisherDTO.getName());
        publisherFound.setVersion(publisherDTO.getVersion());
        return publisherMapper.toDTO(publisherCUDSM.createOrUpdatePublisher(publisherMapper.toDO(publisherFound)));
    }

    @Override
    public void deletePublisherById(Long id) {
        publisherCUDSM.deletePublisherById(id);
    }

}
