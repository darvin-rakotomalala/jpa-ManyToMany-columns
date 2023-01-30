package com.poc.service.application;

import com.poc.mapper.BookMapper;
import com.poc.model.dto.BookDTO;
import com.poc.service.business.BookRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookRSAImpl implements BookRSA {

    private final BookRSM bookRSM;
    private final BookMapper bookMapper;

    @Override
    public BookDTO getBookById(Long id) {
        return bookMapper.toDTO(bookRSM.getBookById(id));
    }

    @Override
    public HelpPage<BookDTO> getAllBooksByTitle(String title, Pageable pageable) {
        return bookMapper.toDTO(bookRSM.getAllBooksByTitle(title, pageable), pageable);
    }

}
