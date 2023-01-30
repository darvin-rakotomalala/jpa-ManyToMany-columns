package com.poc.service.business;

import com.poc.model.domain.Book;
import com.poc.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookCUDSMImpl implements BookCUDSM {

    private final BookRepository bookRepository;
    private final BookRSM bookRSM;

    @Override
    public Book createOrUpdateBook(Book book) {
        try {
            log.info("----- createOrUpdateBook");
            return bookRepository.save(book);
        } catch (Exception e) {
            log.error("Error createOrUpdateBook : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Book> saveAllBooks(List<Book> books) {
        try {
            log.info("----- saveAllBooks");
            return bookRepository.saveAll(books);
        } catch (Exception e) {
            log.error("Error saveAllBooks : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteBookById(Long id) {
        try {
            log.info("----- deleteBookById : {}", id);
            Book bookFound = bookRSM.getBookById(id);
            bookRepository.deleteById(bookFound.getId());
        } catch (Exception e) {
            log.error("Error deleteBookById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
