package com.example.smartemployee.employeeprimax.repository;

import com.example.smartemployee.employeeprimax.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,String> {


    List<Employee> findAllByDepartmentId(String id);

}
