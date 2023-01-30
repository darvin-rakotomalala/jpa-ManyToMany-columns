package com.poc.constraint.validation;

import com.poc.exception.ErrorsEnum;
import com.poc.model.dto.BookPublisherDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookPublisherValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BookPublisherDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookPublisherDTO bookPublisherDTO = (BookPublisherDTO) target;
        if (StringUtils.isEmpty(bookPublisherDTO.getFormat())) {
            errors.rejectValue("format", "format.value.empty", ErrorsEnum.ERR_MCS_BOOK_PUBLISHER_FORMAT_EMPTY.getErrorMessage());
        }
    }

}
