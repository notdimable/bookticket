package com.bookticket.app.api.users.service;

import com.bookticket.app.api.users.Mapper.UserMapper;
import com.bookticket.app.api.users.exception.UserNotFoundException;
import com.bookticket.app.api.users.model.dto.UserDto;
import com.bookticket.app.api.users.model.entity.User;
import com.bookticket.app.api.users.repository.UserRepository;
import com.bookticket.app.api.users.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getDataUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        User user = optionalUser.get();
        UserDto dto = UserMapper.toUserDto(user);
        return dto;
    }
}
