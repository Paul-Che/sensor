package com.myproject.service;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException {

    HttpStatus httpStatus;

    public CommonException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
