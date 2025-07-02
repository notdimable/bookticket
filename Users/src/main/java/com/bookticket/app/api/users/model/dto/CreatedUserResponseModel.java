package com.bookticket.app.api.users.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedUserResponseModel {
    private String firstName;
    private String secondName;
    private String email;
    private String phoneNumber;
}
