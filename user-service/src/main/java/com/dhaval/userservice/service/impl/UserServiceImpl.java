package com.dhaval.userservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dhaval.userservice.VO.Department;
import com.dhaval.userservice.VO.UserNDepartment;
import com.dhaval.userservice.exception.ResourceNotFoundException;
import com.dhaval.userservice.model.User;
import com.dhaval.userservice.repository.UserRepository;
import com.dhaval.userservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public User saveUser(User user) {
    log.info("Inside saveUser method of UserService");

    return userRepository.save(user);
  }

  @Override
  public UserNDepartment getUserWithDepartment(Long userId) {
    log.info("Inside getUserWithDepartment method in UserService");

    UserNDepartment userNDepartment = new UserNDepartment();
    Optional<User> optional = userRepository.findById(userId);

    if (optional.isEmpty())
      throw new ResourceNotFoundException("User", "userId", userId);

    User user = optional.get();

    Department department = restTemplate.getForObject("http://localhost:9001/api/departments/" + user.getDepartmentId(),
        Department.class);

    userNDepartment.setUser(user);
    userNDepartment.setDepartment(department);

    return userNDepartment;

  }

}
