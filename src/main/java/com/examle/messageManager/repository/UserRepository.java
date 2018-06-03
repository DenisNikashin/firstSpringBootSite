package com.examle.messageManager.repository;

import com.examle.messageManager.domaine.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
