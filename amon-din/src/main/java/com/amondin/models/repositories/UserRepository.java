package com.amondin.models.repositories;

import com.amondin.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User finUserByUsername(String username);
}
