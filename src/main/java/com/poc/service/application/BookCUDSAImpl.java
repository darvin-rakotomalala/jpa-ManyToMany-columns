package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.mapper.BookMapper;
import com.poc.model.dto.BookDTO;
import com.poc.service.business.BookCUDSM;
import com.poc.service.business.BookRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookCUDSAImpl implements BookCUDSA {

    private final BookCUDSM bookCUDSM;
    private final BookRSM bookRSM;
    private final BookMapper bookMapper;

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        if (bookDTO == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_BOOK_OBJECT_EMPTY.getErrorMessage());
        }
        return bookMapper.toDTO(bookCUDSM.createOrUpdateBook(bookMapper.toDO(bookDTO)));
    }

    @Override
    public List<BookDTO> saveAllBooks(List<BookDTO> bookDTOs) {
        return bookMapper.toDTO(bookCUDSM.saveAllBooks(bookMapper.toDO(bookDTOs)));
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        if (bookDTO == null || bookDTO.getId() == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_BOOK_OBJECT_EMPTY.getErrorMessage());
        }
        BookDTO bookFound = bookMapper.toDTO(bookRSM.getBookById(bookDTO.getId()));
        bookFound.setTitle(bookDTO.getTitle());
        bookFound.setVersion(bookDTO.getVersion());
        return bookMapper.toDTO(bookCUDSM.createOrUpdateBook(bookMapper.toDO(bookFound)));
    }

    @Override
    public void deleteBookById(Long id) {
        bookCUDSM.deleteBookById(id);
    }

}
