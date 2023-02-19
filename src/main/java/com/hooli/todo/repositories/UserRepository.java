package com.hooli.todo.repositories;

import com.hooli.todo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByEmailAddress(String emailAddress);

    Optional<Object> findByEmailAddress(String emailAddress);
}
