package com.bookticket.app.book.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperBook {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
