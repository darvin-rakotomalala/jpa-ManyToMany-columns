package com.poc.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BookPublisherDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BookDTO book;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PublisherDTO publisher;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String format;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date publicationDate;
}
