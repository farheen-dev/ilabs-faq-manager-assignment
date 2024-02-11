package com.farheen.ilabsfaqmanagerbackend.repository;

import com.farheen.ilabsfaqmanagerbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    Optional<User> findOneByUsernameAndPassword(String username, String encodedPassword);
}
