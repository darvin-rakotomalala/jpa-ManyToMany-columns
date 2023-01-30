package com.poc.exception;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */

    ERR_MCS_BOOK_TITLE_EMPTY("Error occurred - Book title shouldn't be NULL or EMPTY"),
    ERR_MCS_PUBLISHER_NAME_EMPTY("Error occurred - Publisher name shouldn't be NULL or EMPTY"),
    ERR_MCS_BOOK_PUBLISHER_FORMAT_EMPTY("Error occurred - BookPublisher format shouldn't be NULL or EMPTY"),
    ERR_MCS_BOOK_OBJECT_EMPTY("Error occurred - object or id Book shouldn't be NULL or EMPTY"),
    ERR_MCS_PUBLISHER_OBJECT_EMPTY("Error occurred - object or id Publisher shouldn't be NULL or EMPTY"),
    ERR_MCS_BOOK_NOT_FOUND("Error occurred - no Book found with this id"),
    ERR_MCS_PUBLISHER_NOT_FOUND("Error occurred - no Publisher found with this id");
    private final String errorMessage;

    private ErrorsEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return " errorMessage : " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
