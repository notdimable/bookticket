package com.bookticket.app.api.admin.service;

import com.bookticket.app.api.admin.exception.FlightAlreadyExistException;
import com.bookticket.app.api.admin.exception.FlightNotFoundException;

import com.bookticket.app.api.admin.repository.FlightRepository;
import com.bookticket.app.api.admin.service.interfaces.AdminService;
import com.bookticket.app.core.model.FlightEntity;
import com.bookticket.app.core.model.dto.CreateFlightRequest;
import com.bookticket.app.core.model.dto.FlightDto;
import com.bookticket.app.core.model.dto.UpdateFlightRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    public AdminServiceImpl(FlightRepository flightRepository, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FlightDto> getFlights() {
        List<FlightEntity> flightEntities = flightRepository.findAll();

        if (flightEntities.isEmpty()) {
            throw new FlightNotFoundException("No flights found");
        }

        return flightEntities
                .stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .toList();
    }

    @Override
    public FlightDto getFlight(String flightNumber) {
        FlightEntity flight = flightRepository.findByFlightNumber(flightNumber);

        if (flight == null) {
            throw new FlightNotFoundException("Flight with number '%s' not found".formatted(flightNumber));
        }

        return modelMapper.map(flight, FlightDto.class);
    }

    @Override
    public FlightDto createFlight(CreateFlightRequest request) {
        if (flightRepository.existsByFlightNumber(request.getFlightNumber())) {
            throw new FlightAlreadyExistException("Flight with number '%s' already exists"
                    .formatted(request.getFlightNumber()));
        }

        FlightEntity flight = modelMapper.map(request, FlightEntity.class);

        FlightEntity saved = flightRepository.save(flight);

        return modelMapper.map(saved, FlightDto.class);
    }

    @Override
    public FlightDto updateFlight(UpdateFlightRequest request) {
        FlightEntity flight = flightRepository.findByFlightNumber(request.getFlightNumber());

        if (flight == null) {
            throw new FlightNotFoundException("Flight with number '%s' not found".formatted(request.getFlightNumber()));
        }
        flight.setDepartureAirport(request.getDepartureAirport());
        flight.setArrivalAirport(request.getArrivalAirport());
        flight.setDepartureTime(request.getDepartureTime());
        flight.setArrivalTime(request.getArrivalTime());
        flight.setAirline(request.getAirline());
        flight.setEconomySeats(request.getEconomySeats());
        flight.setBusinessSeats(request.getBusinessSeats());
        flight.setFirstClassSeats(request.getFirstClassSeats());
        flight.setStatus(request.getStatus());
        flight.setServiceClass(request.getServiceClass());

        FlightEntity updated = flightRepository.save(flight);
        return modelMapper.map(updated, FlightDto.class);
    }

    @Override
    public void deleteFlight(String flightNumber) {
        FlightEntity flight = flightRepository.findByFlightNumber(flightNumber);
        if (flight == null) {
            throw new FlightNotFoundException("Flight with number '%s' not found".formatted(flightNumber));
        }
        flightRepository.delete(flight);
    }
}
