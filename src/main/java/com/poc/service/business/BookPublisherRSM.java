package com.poc.service.business;

import com.poc.model.domain.BookPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookPublisherRSM {
    Page<BookPublisher> getByFormat(String format, Pageable page);
    BookPublisher getByBookTitle(String bookTitle);
    Page<BookPublisher> getByPublisherName(String name, Pageable page);
}
