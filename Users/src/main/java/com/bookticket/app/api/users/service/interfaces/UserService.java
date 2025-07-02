package com.bookticket.app.api.users.service.interfaces;

import com.bookticket.app.api.users.model.Request.CreateUsersRequestModel;
import com.bookticket.app.api.users.model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto getDataUser(Long id);
    UserDto createUser(CreateUsersRequestModel newUser);
    UserDto getUserDetailsByEmail(String email);
}
