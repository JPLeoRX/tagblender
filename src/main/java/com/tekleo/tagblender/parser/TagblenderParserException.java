package com.tekleo.tagblender.parser;

public class TagblenderParserException extends Exception {
    public TagblenderParserException() {

    }

    public TagblenderParserException(String message) {
        super(message);
    }

    public TagblenderParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public TagblenderParserException(Throwable cause) {
        super(cause);
    }

    public TagblenderParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}