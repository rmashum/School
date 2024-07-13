// src/main/java/com/example/demo/repository/UserRepository.java
package com.scholiq.Scholiq.repository;

import com.scholiq.Scholiq.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
