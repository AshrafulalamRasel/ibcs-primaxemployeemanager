package com.example.smartemployee.employeeprimax.services;

import com.example.smartemployee.employeeprimax.config.ResourceNotFoundException;
import com.example.smartemployee.employeeprimax.domain.Department;
import com.example.smartemployee.employeeprimax.domain.Employee;
import com.example.smartemployee.employeeprimax.dto.request.CreateDepartment;
import com.example.smartemployee.employeeprimax.dto.request.UpdateDepartment;
import com.example.smartemployee.employeeprimax.dto.response.*;
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
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public IdentityResponse createDepartment(CreateDepartment createDepartment) {

        if (departmentRepository.existsByCodeAndName(createDepartment.getCode(), createDepartment.getName())) {

            throw new ResourceNotFoundException("AllReady Taken Department code and name");
        }

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        Department department = new Department();
        department.setId(id);
        department.setCode(createDepartment.getCode());
        department.setName(createDepartment.getName());
        department.setActive(createDepartment.isActive());
        departmentRepository.saveAndFlush(department);

        return new IdentityResponse(id);
    }


    public DepartmentListResponse getCheckDepartmentEmployee(String id) {

        List<EmployeeResponses> employeeResponsesList = new ArrayList<>();
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        List<Employee> employeeList = employeeRepository.findAllByDepartmentId(id);

        if (!departmentOptional.isPresent()){
            throw new ResourceNotFoundException("Not found department Id");
        }

        for (Employee employee : employeeList) {
            employee.getDepartment().getId();
            String employeeId, departmentId;
           /* System.out.println("d"+departmentOptional.get().getId());
            System.out.println("e"+employee.getDepartment().getId());*/
            departmentId = departmentOptional.get().getId();
            employeeId = employee.getDepartment().getId();
            if (departmentId == employeeId) {

                EmployeeResponses employeeResponses = new EmployeeResponses();
                employeeResponses.setCode(employee.getCode());
                employeeResponses.setName(employee.getName());
                employeeResponses.setJoiningDate(employee.getJoiningDate());
                employeeResponses.setDateOfBirth(employee.getDateOfBirth());
                employeeResponses.setDesignation(employee.getDesignation());
                employeeResponses.setBasic(employee.getBasic());
                employeeResponses.setGender(employee.getGender());
                employeeResponsesList.add(employeeResponses);
            }
        }

        return DepartmentListResponse.builder()
                .code(departmentOptional.get().getCode())
                .name(departmentOptional.get().getName())
                .active(departmentOptional.get().isActive())
                .employeeList(employeeResponsesList)
                .build();
    }

    public void updateDepartmentBy(String id, UpdateDepartment updateDepartment){
        Optional<Department> departmentOptionalUpdate = departmentRepository.findById(id);
        if (!departmentOptionalUpdate.isPresent()){

        }
        Department department = departmentOptionalUpdate.get();
        department.setActive(updateDepartment.isActive());
        department.setName(updateDepartment.getName());
        department.setCode(updateDepartment.getCode());
        departmentRepository.save(department);
    }

    public List<GetDepartment> getMyDepartmentList() {

        List<GetDepartment> getDepartmentArrayList = new ArrayList<>();
        for (Department department : departmentRepository.findAll()) {
            GetDepartment getDepartment = new GetDepartment();
            getDepartment.setName(department.getName());
            getDepartment.setId(department.getId());
            getDepartmentArrayList.add(getDepartment);
        }

        return getDepartmentArrayList;
    }

    public DepartmentResponse getDepartment(String id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (!optionalDepartment.isPresent()) {

        }
        return DepartmentResponse.builder()
                .code(optionalDepartment.get().getCode())
                .name(optionalDepartment.get().getName())
                .active(optionalDepartment.get().isActive())
                .build();
    }

}
