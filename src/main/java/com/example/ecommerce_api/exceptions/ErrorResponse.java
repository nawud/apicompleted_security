package com.example.ecommerce_api.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ErrorResponse {

    private List<String> messages;
    private int statusCode;
    private String status;

    public ErrorResponse(List<String> messages, HttpStatus status) {

        this.messages = messages;
        this.statusCode = status.value();
        this.status = status.name();

    }

}