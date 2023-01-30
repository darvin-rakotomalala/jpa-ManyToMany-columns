package com.poc.service.application;

import com.poc.mapper.BookPublisherMapper;
import com.poc.model.dto.BookPublisherDTO;
import com.poc.model.requests.BookPublisherRequestId;
import com.poc.service.business.BookPublisherCUDSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BookPublisherCUDSAImpl implements BookPublisherCUDSA {

    private final BookPublisherCUDSM bookPublisherCUDSM;
    private final BookPublisherMapper bookPublisherMapper;

    @Override
    public BookPublisherDTO createBookPublisherById(BookPublisherRequestId requestId) {
        return bookPublisherMapper.toDTO(bookPublisherCUDSM.createBookPublisherById(requestId));
    }

    @Override
    public BookPublisherDTO createBookPublisherByObject(BookPublisherDTO bookPublisherDTO) {

        // TO DO : vérifier bookTitle & publisherName & format si déjà existé

        bookPublisherDTO.setPublicationDate(new Date());
        return bookPublisherMapper.toDTO(bookPublisherCUDSM.createBookPublisherByObject(
                bookPublisherMapper.toDO(bookPublisherDTO)));
    }

}
