package User.repository;

import User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUserRepository extends JpaRepository<User, Long> {}