package com.example.smartemployee.employeeprimax.services;

import com.example.smartemployee.employeeprimax.domain.Department;
import com.example.smartemployee.employeeprimax.domain.Employee;
import com.example.smartemployee.employeeprimax.dto.request.CreateEmployee;
import com.example.smartemployee.employeeprimax.dto.request.UpdateEmployee;
import com.example.smartemployee.employeeprimax.dto.response.DepartmentResponse;
import com.example.smartemployee.employeeprimax.dto.response.EmployeeListResponse;
import com.example.smartemployee.employeeprimax.dto.response.EmployeeResponse;
import com.example.smartemployee.employeeprimax.dto.response.IdentityResponse;
import com.example.smartemployee.employeeprimax.repository.DepartmentRepository;
import com.example.smartemployee.employeeprimax.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    public IdentityResponse createEmployees(CreateEmployee createEmployee) {


        Optional<Department> departmentOptional = departmentRepository.findById(createEmployee.getDepartmentId());
        if (!departmentOptional.isPresent()) {

        }
        Department department = departmentOptional.get();
        if (department.isActive() == false) {
            department.setActive(true);
            departmentRepository.save(department);

        }


        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        Employee employee = new Employee();

        employee.setId(id);
        employee.setCode(createEmployee.getCode());
        employee.setName(createEmployee.getName());
        employee.setJoiningDate(createEmployee.getJoiningDate());
        employee.setDepartment(departmentOptional.get());
        employee.setDateOfBirth(createEmployee.getDateOfBirth());
        employee.setDesignation(createEmployee.getDesignation());
        employee.setBasic(createEmployee.getBasic());
        employee.setGender(createEmployee.getGender());
        employeeRepository.saveAndFlush(employee);

        return new IdentityResponse(id);
    }


    public EmployeeResponse getAllEmployeeBy(String id) {
        List<DepartmentResponse> departmentResponseList = new ArrayList<>();
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()) {

        }
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setName(employeeOptional.get().getDepartment().getName());
        departmentResponse.setCode(employeeOptional.get().getDepartment().getCode());
        departmentResponse.setActive(employeeOptional.get().getDepartment().isActive());
        departmentResponseList.add(departmentResponse);

        return EmployeeResponse.builder()
                .name(employeeOptional.get().getName())
                .code(employeeOptional.get().getCode())
                .joiningDate(employeeOptional.get().getJoiningDate())
                .dateOfBirth(employeeOptional.get().getDateOfBirth())
                .designation(employeeOptional.get().getDesignation())
                .basic(employeeOptional.get().getBasic())
                .gender(employeeOptional.get().getGender())
                .departmentList(departmentResponseList)
                .build();
    }

    public List<EmployeeListResponse> getEmployeeList() {

        List<Employee> employeeList = employeeRepository.findAll();
        List<DepartmentResponse> departmentResponseList = new ArrayList<>();
        List<EmployeeListResponse> employeeListResponseList = new ArrayList<>();

        for (Employee employee : employeeList) {

            DepartmentResponse departmentResponse = new DepartmentResponse();
            departmentResponse.setName(employee.getDepartment().getName());
            departmentResponse.setCode(employee.getDepartment().getCode());
            departmentResponse.setActive(employee.getDepartment().isActive());
            departmentResponseList.add(departmentResponse);

            EmployeeListResponse employeeListResponse = new EmployeeListResponse();
            employeeListResponse.setName(employee.getName());
            employeeListResponse.setCode(employee.getCode());
            employeeListResponse.setJoiningDate(employee.getJoiningDate());
            employeeListResponse.setDateOfBirth(employee.getDateOfBirth());
            employeeListResponse.setDesignation(employee.getDesignation());
            employeeListResponse.setBasic(employee.getBasic());
            employeeListResponse.setGender(employee.getGender());
            employeeListResponse.setDepartmentList(departmentResponseList);
            employeeListResponseList.add(employeeListResponse);
            departmentResponseList = new ArrayList<>();
        }
        return employeeListResponseList;

    }

    public void updateEmployeeProfile(String id, UpdateEmployee updateEmployee){

        Optional<Employee> employeeOptionalUpdate = employeeRepository.findById(id);
        if(!employeeOptionalUpdate.isPresent()){

        }

        Employee employee = employeeOptionalUpdate.get();
        employee.setJoiningDate(updateEmployee.getJoiningDate());
        employee.setDesignation(updateEmployee.getDesignation());
        employee.setBasic(updateEmployee.getBasic());
        employeeRepository.save(employee);

    }

}
