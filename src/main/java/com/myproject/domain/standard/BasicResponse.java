package com.myproject.domain.standard;

public class BasicResponse {

    String code;
    String message = "";

    public BasicResponse() {}

    public BasicResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public BasicResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BasicResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
