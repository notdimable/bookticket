package com.bookticket.app.core.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Flights")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String flightNumber;
    @Column(nullable = false)
    private String departureAirport;
    @Column(nullable = false)
    private String arrivalAirport;
    @Column(nullable = false)
    private LocalDateTime departureTime;
    @Column(nullable = false)
    private LocalDateTime arrivalTime;
    @Column(nullable = false)
    private String airline;
    @Column(nullable = false)
    private int economySeats;
    @Column(nullable = false)
    private int businessSeats;
    @Column(nullable = false)
    private int firstClassSeats;
    @Column(nullable = false)
    private int availableSeats = economySeats + businessSeats + firstClassSeats;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FlightStatus status;
    @Column(nullable = false)
    private ServiceClass serviceClass;
}
