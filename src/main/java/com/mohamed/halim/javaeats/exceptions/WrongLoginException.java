package com.mohamed.halim.javaeats.exceptions;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException() {
        super("Username or Password is wrong");
    }
}
