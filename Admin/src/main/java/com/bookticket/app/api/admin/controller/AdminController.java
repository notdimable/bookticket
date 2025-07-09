package com.bookticket.app.api.admin.controller;


import com.bookticket.app.api.admin.service.interfaces.AdminService;
import com.bookticket.app.core.model.dto.CreateFlightRequest;
import com.bookticket.app.core.model.dto.FlightDto;
import com.bookticket.app.core.model.dto.UpdateFlightRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<FlightDto> flights = adminService.getFlights();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{flightNumber}")
    public ResponseEntity<FlightDto> getFlightByNumber(@PathVariable("flightNumber") String flightNumber) {
        FlightDto flight = adminService.getFlight(flightNumber);
        return ResponseEntity.ok(flight);
    }

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@RequestBody CreateFlightRequest request) {
        FlightDto created = adminService.createFlight(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<FlightDto> updateFlight(@RequestBody UpdateFlightRequest request) {
        FlightDto updated = adminService.updateFlight(request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{flightNumber}")
    public ResponseEntity<Void> deleteFlight(@PathVariable String flightNumber) {
        adminService.deleteFlight(flightNumber);
        return ResponseEntity.noContent().build();
    }


}