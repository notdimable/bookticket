package com.bookticket.app.api.users.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookedflight")
public class BookedFlightController {

    @GetMapping
    public String getFlight() {
        return "Booked Flight";
    }
}
