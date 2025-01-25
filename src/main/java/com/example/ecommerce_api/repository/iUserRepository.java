package com.example.ecommerce_api.repository;

import com.example.ecommerce_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUserRepository extends JpaRepository<User, Long> {}