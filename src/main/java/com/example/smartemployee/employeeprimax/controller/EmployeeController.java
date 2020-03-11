package com.example.smartemployee.employeeprimax.controller;

import com.example.smartemployee.employeeprimax.dto.request.CreateEmployee;
import com.example.smartemployee.employeeprimax.dto.request.UpdateEmployee;
import com.example.smartemployee.employeeprimax.dto.response.EmployeeListResponse;
import com.example.smartemployee.employeeprimax.dto.response.EmployeeResponse;
import com.example.smartemployee.employeeprimax.dto.response.IdentityResponse;
import com.example.smartemployee.employeeprimax.services.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;


    @PostMapping("/create")
    public ResponseEntity<IdentityResponse> createEmployee(@RequestBody @Valid CreateEmployee createEmployee) {
        return new ResponseEntity(employeeService.createEmployees(createEmployee), HttpStatus.CREATED);
    }

    @GetMapping("view/own-profile-by-employee/{id}")
    public EmployeeResponse getAllEmployee(@PathVariable String id) {
        return employeeService.getAllEmployeeBy(id);
    }


    @GetMapping("/show/all-employee-details")
    public List<EmployeeListResponse> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @PutMapping("update-profile-by/{id}")
    public ResponseEntity<Void> updateCalendar(@PathVariable String id,
                                               @RequestBody @Valid UpdateEmployee updateEmployee) {
        employeeService.updateEmployeeProfile(id, updateEmployee);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
