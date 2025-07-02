package com.bookticket.app.api.users.model.Request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestModel {
    private String email;
    @Setter
    private String password;
}
