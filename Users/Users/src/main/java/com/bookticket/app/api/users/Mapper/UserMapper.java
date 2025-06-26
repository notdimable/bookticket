package com.bookticket.app.api.users.Mapper;
import com.bookticket.app.api.users.model.entity.User;
import com.bookticket.app.api.users.model.dto.UserDto;



public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getFirstName(),
                user.getSecondName(),
                user.getAge(),
                user.getEmail(),
                user.getPhoneNumber()
        );
    }

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }
}