package com.mohamed.halim.javaeats.exceptions;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException() {
        super("User name already used before try another name");
    }
}
