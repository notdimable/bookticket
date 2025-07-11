package com.bookticket.app.core.model.dto;


import com.bookticket.app.core.model.ServiceClass;
import lombok.Data;

@Data
public class BookingDto {
    private String username;
    private String userPhone;
    private String flightNumber;
    private ServiceClass serviceClass;
}
