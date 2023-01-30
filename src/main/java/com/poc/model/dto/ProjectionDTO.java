package com.poc.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ProjectionDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String titleBook;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int versionBook;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String namePublisher;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String format;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date publicationDate;
}
