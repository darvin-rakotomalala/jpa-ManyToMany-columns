package com.poc.service.business;

import com.poc.model.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookRSM {
    public Book getBookById(Long id);
    public Page<Book> getAllBooksByTitle(String title, Pageable pageable);
}
