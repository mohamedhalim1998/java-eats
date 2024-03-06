package com.mohamed.halim.javaeats.exceptions;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException() {
        super("email already used before try another name");
    }
}
