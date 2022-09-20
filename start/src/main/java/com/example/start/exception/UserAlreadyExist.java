package com.example.start.exception;

public class UserAlreadyExist extends Exception{
    public UserAlreadyExist(String message) {
        super(message);
    }
}
