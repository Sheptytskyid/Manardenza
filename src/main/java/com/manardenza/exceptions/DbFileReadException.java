package com.manardenza.exceptions;

public class DbFileReadException extends RuntimeException {

    public DbFileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
