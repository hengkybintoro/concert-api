package com.example.concert.exception;

public class ConcertNotFoundException extends RuntimeException {
    public ConcertNotFoundException(String message) {
        super(message);
    }
}
