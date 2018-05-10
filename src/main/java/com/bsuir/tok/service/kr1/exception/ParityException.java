package com.bsuir.tok.service.kr1.exception;

public class ParityException extends Exception {

    public ParityException(String message) {
        super(message);
    }

    public ParityException(String message, Exception e) {
        super(message, e);
    }

    public ParityException(Exception e) {
        super(e);
    }
}
