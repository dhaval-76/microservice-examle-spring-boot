package com.dhaval.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhaval.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
