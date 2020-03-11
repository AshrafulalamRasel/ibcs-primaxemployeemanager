package com.example.smartemployee.employeeprimax.repository;

import com.example.smartemployee.employeeprimax.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {
    Boolean existsByCodeAndName(String name,String code);
}
