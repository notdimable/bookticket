package com.bookticket.app.api.admin.exception;

public class FlightAlreadyExistException extends RuntimeException{
    public FlightAlreadyExistException() {
    }

    public FlightAlreadyExistException(String message) {
        super(message);
    }

    public FlightAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlightAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public FlightAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
