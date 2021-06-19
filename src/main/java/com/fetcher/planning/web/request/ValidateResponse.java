package com.fetcher.planning.web.request;

public class ValidateResponse {
    private int code;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public ValidateResponse(int _code, String _message)
    {
        code= _code;
        message= _message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

}
