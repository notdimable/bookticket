package com.bookticket.app.api.users.service.interfaces;

import com.bookticket.app.api.users.model.dto.UserDto;

public interface UserService {
    UserDto getDataUser(Long id);
}
