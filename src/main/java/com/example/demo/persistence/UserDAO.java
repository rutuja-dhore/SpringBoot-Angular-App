package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity, Integer> {

}
