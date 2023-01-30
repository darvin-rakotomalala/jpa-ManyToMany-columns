package com.poc.model.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class BookPublisherId implements Serializable {

    private static final long serialVersionUID = 8027586519273914057L;
    private Long bookId;
    private Long publisherId;
}
