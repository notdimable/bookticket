package com.bookticket.app.api.users.service.interfaces;

import com.bookticket.app.api.users.model.Request.CreateUsersRequestModel;
import com.bookticket.app.api.users.model.Request.BookFlightRequest;
import com.bookticket.app.api.users.model.dto.CreatedUserResponseModel;
import com.bookticket.app.api.users.model.dto.UserDto;


public interface UserService {
    BookFlightRequest kafkaCheck(BookFlightRequest request) throws Exception;
    CreatedUserResponseModel registerUser(CreateUsersRequestModel request);
}
