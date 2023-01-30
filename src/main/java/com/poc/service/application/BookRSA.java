package com.poc.service.application;

import com.poc.model.dto.BookDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

public interface BookRSA {
    public BookDTO getBookById(Long id);
    public HelpPage<BookDTO> getAllBooksByTitle(String title, Pageable pageable);
}
