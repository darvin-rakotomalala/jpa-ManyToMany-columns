package com.poc.controller;

import com.poc.constraint.validation.BookPublisherValidator;
import com.poc.model.dto.BookPublisherDTO;
import com.poc.model.requests.BookPublisherRequestId;
import com.poc.service.application.BookPublisherCUDSA;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "booksPublishers")
public class BookPublisherController {

    private final BookPublisherCUDSA bookPublisherCUDSA;
    private final BookPublisherValidator bookPublisherValidator;

    @InitBinder("bookPublisherDTO")
    protected void initBookPublisherDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(bookPublisherValidator);
    }

    @Operation(summary = "WS used to create BookPublisher by id")
    @PostMapping("/requestId")
    public BookPublisherDTO createBookPublisherById(@RequestBody @Validated BookPublisherRequestId requestId) {
        return bookPublisherCUDSA.createBookPublisherById(requestId);
    }

    @Operation(summary = "WS used to create BookPublisher by object")
    @PostMapping("/byObject")
    public BookPublisherDTO createBookPublisherByObject(@RequestBody @Validated BookPublisherDTO bookPublisherDTO) {
        return bookPublisherCUDSA.createBookPublisherByObject(bookPublisherDTO);
    }

}
