package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.Book;
import com.poc.repository.BookRepository;
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
public class BookRSMImpl implements BookRSM {

    private final BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        try {
            log.info("----- getBookById : {}", id);
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (optionalBook.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_BOOK_NOT_FOUND.getErrorMessage());
            }
            return optionalBook.get();
        } catch (Exception e) {
            log.error("Error getBookById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Page<Book> getAllBooksByTitle(String title, Pageable pageable) {
        try {
            log.info("----- getAllBooksByTitle : {}", title);
            if (StringUtils.isBlank(title)) {
                return bookRepository.findAll(pageable);
            } else {
                return bookRepository.findByTitleContainingIgnoreCase(title, pageable);
            }
        } catch (Exception e) {
            log.error("Error getAllBooksByTitle : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
