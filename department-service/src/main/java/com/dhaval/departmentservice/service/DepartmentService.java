package com.dhaval.departmentservice.service;

import com.dhaval.departmentservice.model.Department;

public interface DepartmentService {

  public Department saveDepartment(Department department);

  public Department findDepartmentById(Long departmentId);

}
