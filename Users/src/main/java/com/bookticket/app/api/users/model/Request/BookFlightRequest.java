package com.bookticket.app.api.users.model.Request;

import com.bookticket.app.core.model.ServiceClass;
import lombok.Data;

@Data
public class BookFlightRequest {
    String username;
    String phoneNumber;
    String flightNumber;
    ServiceClass serviceClass;
}
