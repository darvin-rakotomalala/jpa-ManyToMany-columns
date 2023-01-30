package com.poc.constraint.validation;

import com.poc.exception.ErrorsEnum;
import com.poc.model.dto.PublisherDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PublisherValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PublisherDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PublisherDTO publisherDTO = (PublisherDTO) target;
        if (StringUtils.isEmpty(publisherDTO.getName())) {
            errors.rejectValue("name", "name.value.empty", ErrorsEnum.ERR_MCS_PUBLISHER_NAME_EMPTY.getErrorMessage());
        }
    }

}
