package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.Book;
import com.poc.model.domain.BookPublisher;
import com.poc.model.domain.Publisher;
import com.poc.model.requests.BookPublisherRequestId;
import com.poc.repository.BookPublisherRepository;
import com.poc.repository.BookRepository;
import com.poc.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookPublisherCUDSMImpl implements BookPublisherCUDSM {

    private final BookPublisherRepository bookPublisherRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public BookPublisher createBookPublisherById(BookPublisherRequestId requestId) {
        try {
            log.info("----- createBookPublisherById");

            Optional<Book> optBook = bookRepository.findById(requestId.getIdBook());
            if (optBook.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_BOOK_NOT_FOUND.getErrorMessage());
            }

            Optional<Publisher> optPublisher = publisherRepository.findById(requestId.getIdPublisher());
            if (optPublisher.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_PUBLISHER_NOT_FOUND.getErrorMessage());
            }

            BookPublisher newBookPublisher = new BookPublisher();
            newBookPublisher.setBook(optBook.get());
            newBookPublisher.setPublisher(optPublisher.get());
            newBookPublisher.setFormat(requestId.getFormat());
            newBookPublisher.setPublicationDate(new Date());
            return bookPublisherRepository.save(newBookPublisher);
        } catch (Exception e) {
            log.error("Error createBookPublisherById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public BookPublisher createBookPublisherByObject(BookPublisher bookPublisher) {
        try {
            log.info("----- createBookPublisherByObject");
            return bookPublisherRepository.save(bookPublisher);
        } catch (Exception e) {
            log.error("Error createBookPublisherByObject : {} {}", e.getMessage(), e);
            throw e;
        }
    }
}
