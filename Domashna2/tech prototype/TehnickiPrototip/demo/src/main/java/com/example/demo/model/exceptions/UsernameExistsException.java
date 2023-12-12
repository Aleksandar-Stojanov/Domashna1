package com.example.demo.model.exceptions;

public class UsernameExistsException extends RuntimeException {
    public UsernameExistsException(){super("Username is already taken!");};
}

