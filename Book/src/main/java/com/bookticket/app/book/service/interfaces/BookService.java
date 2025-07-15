package com.bookticket.app.book.service.interfaces;

import com.bookticket.app.core.model.ServiceClass;
import java.util.Map;

public interface BookService {
    Map<String, String> getBookFlight(String flightNumber);
    String getFreeSeats(String flightNumber);
    void registerBookFlight(String flightNumber, String name, String userPhone, ServiceClass serviceClass);

    void updatedBookedFlight(String userPhone);

    void cancelBookedFlight(String userPhone);
}
