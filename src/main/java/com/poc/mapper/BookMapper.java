package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.Book;
import com.poc.model.dto.BookDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper extends DtoMapper<BookDTO, Book> {

}
