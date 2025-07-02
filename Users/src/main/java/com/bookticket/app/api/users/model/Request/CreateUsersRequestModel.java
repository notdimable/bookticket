package com.bookticket.app.api.users.model.Request;

import lombok.Getter;

@Getter
public class CreateUsersRequestModel {
    private String firstName;
    private String secondName;
    private String password;
    private int age;
    private String email;
    private String phoneNumber;
}
