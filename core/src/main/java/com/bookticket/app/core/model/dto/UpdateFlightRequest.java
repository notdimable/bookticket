package com.bookticket.app.core.model.dto;

import com.bookticket.app.core.model.FlightStatus;
import com.bookticket.app.core.model.ServiceClass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateFlightRequest {
    private String flightNumber; // по нему ищем
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String airline;
    private int economySeats;
    private int businessSeats;
    private int firstClassSeats;
    private FlightStatus status;
    private ServiceClass serviceClass;
}