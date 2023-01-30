package com.poc.constraint.validation;

import com.poc.exception.ErrorsEnum;
import com.poc.model.dto.BookDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BookDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDTO bookDTO = (BookDTO) target;
        if (StringUtils.isEmpty(bookDTO.getTitle())) {
            errors.rejectValue("title", "title.value.empty", ErrorsEnum.ERR_MCS_BOOK_TITLE_EMPTY.getErrorMessage());
        }
    }

}
