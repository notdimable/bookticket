package com.bookticket.app.api.users.exception;

public class PhoneNumberAlreadyExistsException extends RuntimeException {
    public PhoneNumberAlreadyExistsException(String phoneNumber) {
        super("Phone number already exist: " + phoneNumber);
    }
}