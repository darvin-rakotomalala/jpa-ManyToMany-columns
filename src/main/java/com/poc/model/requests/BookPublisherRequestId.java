package com.poc.model.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookPublisherRequestId {
    private Long idBook;
    private Long idPublisher;
    private String format;
    private Date publicationDate;
}
