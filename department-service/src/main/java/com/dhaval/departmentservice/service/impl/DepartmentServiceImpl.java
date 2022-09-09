package com.dhaval.departmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhaval.departmentservice.exception.ResourceNotFoundException;
import com.dhaval.departmentservice.model.Department;
import com.dhaval.departmentservice.repository.DepartmentRepository;
import com.dhaval.departmentservice.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Override
  public Department saveDepartment(Department department) {
    log.info("Inside saveDepartment method of DepartmentService");

    return departmentRepository.save(department);
  }

  @Override
  public Department findDepartmentById(Long departmentId) {
    log.info("Inside findDepartmentById method of DepartmentService");

    return departmentRepository.findById(departmentId)
        .orElseThrow(() -> new ResourceNotFoundException("Department", "DepartmentId", departmentId));
  }
}
