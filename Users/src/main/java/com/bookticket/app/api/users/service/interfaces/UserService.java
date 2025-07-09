package com.bookticket.app.api.users.service.interfaces;

import com.bookticket.app.api.users.model.Request.CreateUsersRequestModel;
import com.bookticket.app.api.users.model.dto.UserDto;


public interface UserService {
    UserDto getDataUser(Long id);
    UserDto createUser(CreateUsersRequestModel newUser);
    UserDto getUserDetailsByEmail(String email);
}
