package com.bookticket.app.api.users.exception;

public class UserNotFoundException extends IllegalArgumentException {

    public  UserNotFoundException(String email) {
        super("Email is not found " + email);
    }

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
