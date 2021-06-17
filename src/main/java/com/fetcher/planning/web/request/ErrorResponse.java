package com.fetcher.planning.web.request;

public class ErrorResponse {
    private int error;
    private String message;

    public ErrorResponse(int _error, String _message)
    {
        error= _error;
        message= _message;
    }
}
