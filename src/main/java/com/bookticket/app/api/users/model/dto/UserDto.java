package com.bookticket.app.api.users.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String secondName;
    private int age;
    private String email;
    private String phoneNumber;
}
