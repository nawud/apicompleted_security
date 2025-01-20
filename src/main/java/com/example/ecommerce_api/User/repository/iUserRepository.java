package com.example.ecommerce_api.User.repository;

import com.example.ecommerce_api.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUserRepository extends JpaRepository<User, Long> {}