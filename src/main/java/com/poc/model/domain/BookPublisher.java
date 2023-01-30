package com.poc.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_publisher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookPublisher {
    @EmbeddedId
    private BookPublisherId id = new BookPublisherId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("bookId")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("publisherId")
    private Publisher publisher;

    private String format;
    private Date publicationDate;
}
