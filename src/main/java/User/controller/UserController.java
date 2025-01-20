package User.controller;

import User.model.User;
import User.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    // CREATE
    @PostMapping("")
    public void createUser(@RequestBody User newUser) { userService.addUser(newUser); }

    // READ
    @GetMapping("")
    public List<User> readAllUsers() { return userService.readUsers(); }

    // UPDATE
    @PutMapping("")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User updatingUser) {

        try {

            User user = userService.updateUser(id, updatingUser);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

        } catch (Exception e) { return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE); }

    }

    // DELETE
    @DeleteMapping("")
    public void deleteUser(@PathVariable long id) { userService.deleteUser(id); }

    /* FILTERS */

    // ID
    @GetMapping("")
    public ResponseEntity<User> findUserById(@PathVariable long id) {

        Optional<User> foundUser = userService.findUserById(id);

        if (foundUser.isPresent()) {

            return new ResponseEntity<>(foundUser.get(), HttpStatus.FOUND);

        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}