package com.poc.service.business;

import com.poc.model.domain.BookPublisher;
import com.poc.repository.BookPublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookPublisherRSMImpl implements BookPublisherRSM {

    private final BookPublisherRepository bookPublisherRepository;

    @Override
    public Page<BookPublisher> getByFormat(String format, Pageable page) {
        return null;
    }

    @Override
    public BookPublisher getByBookTitle(String bookTitle) {
        return null;
    }

    @Override
    public Page<BookPublisher> getByPublisherName(String name, Pageable page) {
        return null;
    }

}
