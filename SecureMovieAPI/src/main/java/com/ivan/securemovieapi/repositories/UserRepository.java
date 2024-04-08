package com.ivan.securemovieapi.repositories;

import com.ivan.securemovieapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
