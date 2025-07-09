package com.bookticket.app.api.admin.service.interfaces;



import com.bookticket.app.core.model.dto.CreateFlightRequest;
import com.bookticket.app.core.model.dto.FlightDto;
import com.bookticket.app.core.model.dto.UpdateFlightRequest;

import java.util.List;

public interface AdminService {
    List<FlightDto> getFlights();
    FlightDto getFlight(String numberFlight);

    FlightDto createFlight(CreateFlightRequest request);

    FlightDto updateFlight(UpdateFlightRequest request);

    void deleteFlight(String flightNumber);
}
