package com.poc.service.application;

import com.poc.model.dto.BookPublisherDTO;
import com.poc.model.requests.BookPublisherRequestId;

public interface BookPublisherCUDSA {
    BookPublisherDTO createBookPublisherById(BookPublisherRequestId requestId);

    BookPublisherDTO createBookPublisherByObject(BookPublisherDTO bookPublisherDTO);
}
