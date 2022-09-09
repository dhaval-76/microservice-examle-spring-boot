package com.dhaval.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhaval.userservice.VO.UserNDepartment;
import com.dhaval.userservice.model.User;
import com.dhaval.userservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public User saveUser(@RequestBody User user) {
    log.info("Inside saveUser method of UserController");

    return userService.saveUser(user);
  }

  @GetMapping("/{id}")
  public UserNDepartment getUserWithDepartment(@PathVariable("id") Long userId) {
    log.info("Inside getUserWithDepartment method in UserController");

    return userService.getUserWithDepartment(userId);
  } 
}
