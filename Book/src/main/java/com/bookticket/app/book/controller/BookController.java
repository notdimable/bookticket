package com.bookticket.app.book.controller;

import com.bookticket.app.book.service.interfaces.BookService;
import com.bookticket.app.core.model.ServiceClass;
import com.bookticket.app.core.model.dto.BookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/flight/{flightNumber}")
    public ResponseEntity<Map<String, String>> getBookFlight(@PathVariable String flightNumber) {
        return ResponseEntity.ok().body(bookService.getBookFlight(flightNumber));
    }

    @GetMapping("/freeSeats/{flightNumber}")
    public ResponseEntity<String> getFreeSeats(@PathVariable String flightNumber) {
        return ResponseEntity.ok().body(bookService.getFreeSeats(flightNumber));
    }


    @PostMapping("/register/{flightNumber}")
    public ResponseEntity<Void> registerBookFlight(@PathVariable String flightNumber, String name
            , String userPhone, ServiceClass serviceClass) {
        bookService.registerBookFlight(flightNumber, name, userPhone, serviceClass);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<BookingDto> updatedBookedFlight(@RequestBody String userPhone) {
        bookService.updatedBookedFlight(userPhone);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<Void> cancelBookedFlight(@RequestBody String userPhone) {
        bookService.cancelBookedFlight(userPhone);
        return ResponseEntity.ok().build();
    }
}
