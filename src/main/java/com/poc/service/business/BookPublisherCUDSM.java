package com.poc.service.business;

import com.poc.model.domain.BookPublisher;
import com.poc.model.requests.BookPublisherRequestId;

public interface BookPublisherCUDSM {
    BookPublisher createBookPublisherById(BookPublisherRequestId requestId);
    BookPublisher createBookPublisherByObject(BookPublisher bookPublisher);
}
