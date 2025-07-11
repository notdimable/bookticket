package com.bookticket.app.book.service;

import com.bookticket.app.book.repository.BookRepository;
import com.bookticket.app.book.service.interfaces.BookService;
import com.bookticket.app.core.model.ServiceClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;


    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Map<String, String> getBookFlight(String flightNumber) {

        return Map.of();
    }

    @Override
    public String getFreeSeats(String flightNumber) {
        return "";
    }

    @Override
    public void registerBookFlight(String flightNumber, String name, String userPhone, ServiceClass serviceClass) {

    }

    @Override
    public void updatedBookedFlight(String userPhone) {

    }

    @Override
    public void cancelBookedFlight(String userPhone) {

    }
}
