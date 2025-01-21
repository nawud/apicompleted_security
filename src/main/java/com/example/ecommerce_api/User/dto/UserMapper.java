package com.example.ecommerce_api.User.dto;

import com.example.ecommerce_api.User.model.User;

public class UserMapper {
    public static User DTOToEntity(UserRequest userRequest) {
        return new User(
                userRequest.username(),
                userRequest.email(),
                userRequest.password()
        );
    }

    public static UserResponse EntityToDTO(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}