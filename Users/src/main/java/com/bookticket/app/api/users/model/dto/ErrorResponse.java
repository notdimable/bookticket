package com.bookticket.app.api.users.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorResponse {

    private String error;
    private int status;
    private LocalDateTime timestamp;

    public ErrorResponse(String error, int status) {
        this.error = error;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }


}
