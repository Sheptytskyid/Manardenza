package com.manardenza.exceptions;

public class DbFileWriteException extends RuntimeException {

    public DbFileWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
