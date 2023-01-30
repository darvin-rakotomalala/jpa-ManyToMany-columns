package com.poc.controller;

import com.poc.constraint.validation.BookValidator;
import com.poc.model.dto.BookDTO;
import com.poc.service.application.BookCUDSA;
import com.poc.service.application.BookRSA;
import com.poc.utils.HelpPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "books")
public class BookController {

    private final BookCUDSA bookCUDSA;
    private final BookRSA bookRSA;
    private final BookValidator bookValidator;

    @InitBinder("bookDTO")
    protected void initBookDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(bookValidator);
    }

    @Operation(summary = "WS used to create book")
    @PostMapping
    public BookDTO createBook(@RequestBody @Validated BookDTO bookDTO) {
        return bookCUDSA.createBook(bookDTO);
    }

    @Operation(summary = "WS used to save all books")
    @PostMapping("/saveAll")
    public List<BookDTO> saveAllBooks(@RequestBody List<BookDTO> bookDTOs) {
        return bookCUDSA.saveAllBooks(bookDTOs);
    }

    @Operation(summary = "WS used to update book")
    @PutMapping
    public BookDTO updateBook(@RequestBody @Validated BookDTO bookDTO) {
        return bookCUDSA.updateBook(bookDTO);
    }

    @Operation(summary = "WS used to get all books")
    @GetMapping
    public HelpPage<BookDTO> getAllBooks(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRSA.getAllBooksByTitle(title, pageable);
    }

    @Operation(summary = "WS used to get book by id")
    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable("id") Long id) {
        return bookRSA.getBookById(id);
    }

    @Operation(summary = "WS used to delete book by id")
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable("id") Long id) {
        bookCUDSA.deleteBookById(id);
        return "Book with id " + id + " deleted successfully !";
    }

}
