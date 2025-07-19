package com.bookticket.app.api.users.service;

import com.bookticket.app.api.users.exception.EmailAlreadyExistsException;
import com.bookticket.app.api.users.exception.PhoneNumberAlreadyExistsException;
import com.bookticket.app.api.users.exception.UserNotFoundException;
import com.bookticket.app.api.users.model.Request.CreateUsersRequestModel;
import com.bookticket.app.api.users.model.Request.BookFlightRequest;
import com.bookticket.app.api.users.model.dto.CreatedUserResponseModel;
import com.bookticket.app.api.users.model.dto.UserDto;
import com.bookticket.app.api.users.model.entity.UserEntity;
import com.bookticket.app.api.users.repository.UserRepository;
import com.bookticket.app.api.users.service.interfaces.UserService;

import com.bookticket.app.core.model.BookFlightCreatedEvent;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.hibernate.sql.results.LoadingLogger.LOGGER;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper, KafkaTemplate kafkaTemplate, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public BookFlightRequest kafkaCheck(BookFlightRequest request) throws Exception {
        String flightId = UUID.randomUUID().toString();

        BookFlightCreatedEvent event = new BookFlightCreatedEvent();
        event.setFlightEventId(flightId);
        event.setUsername(request.getUsername());
        event.setPhoneNumber(request.getPhoneNumber());
        event.setFlightNumber(request.getFlightNumber());
        event.setServiceClass(request.getServiceClass());

        CompletableFuture<SendResult<String, BookFlightCreatedEvent>> future =
                kafkaTemplate.send("flight-booked-event-topic", flightId, event);
        future.whenComplete((result, exception) -> {
            if (exception != null) {
                LOGGER.error("Error");
            } else {
                LOGGER.info("INFO");
            }
        });
        future.join();

        return request;
    }

    @Override
    public CreatedUserResponseModel registerUser(CreateUsersRequestModel request) {
        if(request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        Optional<UserEntity> existingEmailUser = userRepository.findByEmail(request.getEmail());
        if (existingEmailUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        Optional<UserEntity> existingPhoneUser = userRepository.findByPhoneNumber(request.getPhoneNumber());
        if (existingPhoneUser.isPresent()) {
            throw new PhoneNumberAlreadyExistsException("Phone number already exists");
        }

        UserEntity user = modelMapper.map(request, UserEntity.class);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);

        return modelMapper.map(user, CreatedUserResponseModel.class);
    }


}