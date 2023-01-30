package com.poc.controller;

import com.poc.constraint.validation.PublisherValidator;
import com.poc.model.dto.PublisherDTO;
import com.poc.service.application.PublisherCUDSA;
import com.poc.service.application.PublisherRSA;
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
@RequestMapping(path = "publishers")
public class PublisherController {

    private final PublisherCUDSA publisherCUDSA;
    private final PublisherRSA publisherRSA;
    private final PublisherValidator publisherValidator;

    @InitBinder("publisherDTO")
    protected void initPublisherDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(publisherValidator);
    }

    @Operation(summary = "WS used to create publisher")
    @PostMapping
    public PublisherDTO createPublisher(@RequestBody @Validated PublisherDTO publisherDTO) {
        return publisherCUDSA.createPublisher(publisherDTO);
    }

    @Operation(summary = "WS used to save all publishers")
    @PostMapping("/saveAll")
    public List<PublisherDTO> saveAllPublishers(@RequestBody List<PublisherDTO> publisherDTOs) {
        return publisherCUDSA.saveAllPublishers(publisherDTOs);
    }

    @Operation(summary = "WS used to update publisher")
    @PutMapping
    public PublisherDTO updatePublisher(@RequestBody @Validated PublisherDTO publisherDTO) {
        return publisherCUDSA.updatePublisher(publisherDTO);
    }

    @Operation(summary = "WS used to get all publishers")
    @GetMapping
    public HelpPage<PublisherDTO> getAllPublishers(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return publisherRSA.getAllPublishersByName(title, pageable);
    }

    @Operation(summary = "WS used to get publisher by id")
    @GetMapping("/{id}")
    public PublisherDTO getPublisherById(@PathVariable("id") Long id) {
        return publisherRSA.getPublisherById(id);
    }

    @Operation(summary = "WS used to delete publisher by id")
    @DeleteMapping("/{id}")
    public String deletePublisherById(@PathVariable("id") Long id) {
        publisherCUDSA.deletePublisherById(id);
        return "Publisher with id " + id + " deleted successfully !";
    }

}
