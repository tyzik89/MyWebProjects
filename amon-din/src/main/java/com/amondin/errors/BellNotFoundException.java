package com.amondin.errors;

public class BellNotFoundException extends RuntimeException {

    public BellNotFoundException(Long id) {
        super("Bell is not found : " + id);
    }
}
