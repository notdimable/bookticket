package com.bookticket.app.api.admin.model;

import com.bookticket.app.core.model.FlightStatus;
import com.bookticket.app.core.model.ServiceClass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateFlightRequest {
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String airline;
    private int economySeats;
    private int businessSeats;
    private int firstClassSeats;
    private int availableSeats;
    private FlightStatus status;
    private ServiceClass serviceClass;

    public CreateFlightRequest(String flightNumber, String departureAirport, String arrivalAirport,
                               LocalDateTime departureTime, LocalDateTime arrivalTime, String airline,
                               int economySeats, int businessSeats, int firstClassSeats,
                               FlightStatus status, ServiceClass serviceClass) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airline = airline;
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
        this.firstClassSeats = firstClassSeats;
        this.availableSeats = economySeats + businessSeats + firstClassSeats;
        this.status = status;
        this.serviceClass = serviceClass;
    }
}