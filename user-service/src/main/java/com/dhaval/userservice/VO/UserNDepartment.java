package com.dhaval.userservice.VO;

import com.dhaval.userservice.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNDepartment {

  private User user;
  private Department department;
}
