package com.bookticket.app.core.model;

import lombok.Data;

import java.util.UUID;

@Data
public class BookFlightCreatedEvent {
    String flightEventId;
    String username;
    String phoneNumber;
    String flightNumber;
    ServiceClass serviceClass;
}
