package User.service;

import User.model.User;
import User.repository.iUserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final iUserRepository iUserRepository;

    public UserService(iUserRepository iUserRepository) { this.iUserRepository = iUserRepository; }

    // CREATE
    public User addUser(User newUser) { return iUserRepository.save(newUser); }

    // READ
    public List<User> readUsers() { return iUserRepository.findAll(); }

    // UPDATE
    public User updateUser(long id, User updatingUser) {

        Optional<User> foundUser = iUserRepository.findById(id);

        if (foundUser.isPresent()) {

            User existingUser = foundUser.get();

            existingUser.setUsername(updatingUser.getUsername());
            existingUser.setEmail(updatingUser.getEmail());
            existingUser.setPassword(updatingUser.getPassword());

            return iUserRepository.save(existingUser);

        } throw new RuntimeException("User with id: " + id + " not found.");

    }

    // DELETE
    public void deleteUser(long id) { iUserRepository.deleteById(id); }

    /* FILTERS */

    // Id
    public Optional<User> findUserById(long id) { return iUserRepository.findById(id); }

}
