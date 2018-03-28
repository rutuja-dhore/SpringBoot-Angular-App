package com.example.demo.exception;

@SuppressWarnings("serial")
public class UserNullException extends RuntimeException {
    public UserNullException(String message)
    {
        super(message);
    }
}