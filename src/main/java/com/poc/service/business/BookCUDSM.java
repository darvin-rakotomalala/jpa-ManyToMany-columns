package com.poc.service.business;

import com.poc.model.domain.Book;

import java.util.List;

public interface BookCUDSM {
    public Book createOrUpdateBook(Book book);
    public List<Book> saveAllBooks(List<Book> books);
    public void deleteBookById(Long id);
}
