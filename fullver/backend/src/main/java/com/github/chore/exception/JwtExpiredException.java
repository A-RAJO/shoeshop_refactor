package com.github.chore.exception;

public class JwtExpiredException extends RuntimeException {
    public JwtExpiredException(String message) {super(message);}
}
