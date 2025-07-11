package com.bookticket.app.api.users.controller;

import com.bookticket.app.api.users.service.interfaces.BookingService;
import com.bookticket.app.core.model.dto.BookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookingController {
    private BookingService bookService;

    public BookingController(BookingService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookingDto> bookingFlight(@RequestBody BookingDto bookingDto) {
        return ResponseEntity.ok().body(bookService.bookingFlight(bookingDto));
    }
}
