package com.dhaval.userservice.service;

import com.dhaval.userservice.VO.UserNDepartment;
import com.dhaval.userservice.model.User;

public interface UserService {

  public User saveUser(User user);

  public UserNDepartment getUserWithDepartment(Long userId);

}
