package com.bookticket.app.api.users.service;

import com.bookticket.app.api.users.exception.EmailAlreadyExistsException;
import com.bookticket.app.api.users.exception.PhoneNumberAlreadyExistsException;
import com.bookticket.app.api.users.exception.UserNotFoundException;
import com.bookticket.app.api.users.model.Request.CreateUsersRequestModel;
import com.bookticket.app.api.users.model.dto.UserDto;
import com.bookticket.app.api.users.model.entity.UserEntity;
import com.bookticket.app.api.users.repository.UserRepository;
import com.bookticket.app.api.users.service.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto getDataUser(Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity user = optionalUser.get();
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto createUser(CreateUsersRequestModel newUser) {
        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new EmailAlreadyExistsException(newUser.getEmail());
        } if (userRepository.existsByPhoneNumber(newUser.getPhoneNumber())) {
            throw new PhoneNumberAlreadyExistsException(newUser.getPhoneNumber());
        }

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity user = modelMapper.map(newUser, UserEntity.class);
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserDetailsByEmail(String email) {
        return null;
    }
}
