package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.BookPublisher;
import com.poc.model.dto.BookPublisherDTO;
import com.poc.model.dto.ProjectionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class, PublisherMapper.class})
public interface BookPublisherMapper extends DtoMapper<BookPublisherDTO, BookPublisher> {

    @Mappings({
            @Mapping(target = "titleBook", source = "book.title"),
            @Mapping(target = "versionBook", source = "book.version"),
            @Mapping(target = "namePublisher", source = "publisher.name"),})
    ProjectionDTO projectionToDto(BookPublisher data);

    List<ProjectionDTO> listProjectionDtosToDtos(List<BookPublisher> bookPublishers);

    default Page<ProjectionDTO> toPageProjectionDto(Page<BookPublisher> datas, Pageable page) {
        List<ProjectionDTO> listDto = listProjectionDtosToDtos(datas.getContent());
        return new PageImpl<>(listDto, page, datas.getTotalElements());
    }

}
