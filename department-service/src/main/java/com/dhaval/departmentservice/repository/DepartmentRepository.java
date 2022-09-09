package com.dhaval.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhaval.departmentservice.model.Department;

// @Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
