package com.tekleo.tagblender.api;

public class TagblenderApiException extends Exception {
    public TagblenderApiException() {

    }

    public TagblenderApiException(String message) {
        super(message);
    }

    public TagblenderApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public TagblenderApiException(Throwable cause) {
        super(cause);
    }

    public TagblenderApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}