package com.poc.service.application;

import com.poc.model.dto.BookDTO;

import java.util.List;

public interface BookCUDSA {
    public BookDTO createBook(BookDTO bookDTO);
    public List<BookDTO> saveAllBooks(List<BookDTO> bookDTOs);
    public BookDTO updateBook(BookDTO bookDTO);
    public void deleteBookById(Long id);
}
