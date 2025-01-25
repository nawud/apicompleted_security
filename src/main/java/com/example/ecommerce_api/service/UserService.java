package com.example.ecommerce_api.service;

import com.example.ecommerce_api.dto.User.UserMapper;
import com.example.ecommerce_api.dto.User.UserRequest;
import com.example.ecommerce_api.dto.User.UserResponse;
import com.example.ecommerce_api.model.User;
import com.example.ecommerce_api.repository.iUserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final iUserRepository iUserRepository;

    public UserService(iUserRepository iUserRepository) { this.iUserRepository = iUserRepository; }

    // CREATE
    public UserResponse addUser(UserRequest userRequest) {
        User newUser = UserMapper.DTOToEntity(userRequest);
        User savedUser = iUserRepository.save(newUser);
        return UserMapper.EntityToDTO(savedUser);
    }

    // READ
    public List<UserResponse> readUsers()

    {
        List<User> users = iUserRepository.findAll();
    if (users.isEmpty()) throw new RuntimeException("Not found");

    return users.stream().map(User -> UserMapper.EntityToDTO(User)).toList();
    }

    // UPDATE
    public User updateUser(long id, UserRequest userRequest) {

        Optional<User> foundUser = iUserRepository.findById(id);

        if (foundUser.isPresent()) {

            User existingUser = foundUser.get();

            existingUser.setUsername(userRequest.username());
            existingUser.setEmail(userRequest.email());
            existingUser.setPassword(userRequest.password());

            return iUserRepository.save(existingUser);

        } throw new RuntimeException("User with id: " + id + " not found.");

    }

    // DELETE
    public void deleteUser(long id) { iUserRepository.deleteById(id); }

    /* FILTERS */

    // Id
    public Optional<User> findUserById(long id) { return iUserRepository.findById(id); }

}
