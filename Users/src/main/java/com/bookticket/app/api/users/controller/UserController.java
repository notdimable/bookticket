package com.bookticket.app.api.users.controller;

import com.bookticket.app.api.users.model.Request.CreateUsersRequestModel;

import com.bookticket.app.api.users.model.Request.BookFlightRequest;
import com.bookticket.app.api.users.model.dto.CreatedUserResponseModel;
import com.bookticket.app.api.users.model.dto.UserDto;
import com.bookticket.app.api.users.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String instanceId;

    @GetMapping("/check")
    public String status() {
        return "user-service:" + instanceId;
    }

    @PostMapping("/kafkaCheck")
    public ResponseEntity<BookFlightRequest> kafkaCheck(@RequestBody BookFlightRequest request) throws Exception {
        userService.kafkaCheck(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getDataUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<CreatedUserResponseModel> createUser(@Valid @RequestBody CreateUsersRequestModel newUser) {
        UserDto user = userService.createUser(newUser);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        CreatedUserResponseModel createdUserResponseModel = modelMapper.map(user, CreatedUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserResponseModel);
    }
}

