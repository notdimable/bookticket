package com.bookticket.app.api.admin.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperFlight {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
