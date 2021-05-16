package com.example.vacinaja.exception;

public class EmailException extends RuntimeException{
    public EmailException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public EmailException(String exMessage) {
        super(exMessage);
    }
}
