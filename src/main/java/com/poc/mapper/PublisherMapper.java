package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.Publisher;
import com.poc.model.dto.PublisherDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PublisherMapper extends DtoMapper<PublisherDTO, Publisher> {

}
