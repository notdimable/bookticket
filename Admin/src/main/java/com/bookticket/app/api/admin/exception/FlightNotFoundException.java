package com.bookticket.app.api.admin.exception;

public class FlightNotFoundException extends IllegalArgumentException{
    public FlightNotFoundException() {
    }

    public FlightNotFoundException(String s) {
        super(s);
    }

    public FlightNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlightNotFoundException(Throwable cause) {
        super(cause);
    }
}
