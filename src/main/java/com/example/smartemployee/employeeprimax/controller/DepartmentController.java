package com.example.smartemployee.employeeprimax.controller;

import com.example.smartemployee.employeeprimax.dto.request.CreateDepartment;
import com.example.smartemployee.employeeprimax.dto.request.UpdateDepartment;
import com.example.smartemployee.employeeprimax.dto.response.DepartmentListResponse;
import com.example.smartemployee.employeeprimax.dto.response.DepartmentResponse;
import com.example.smartemployee.employeeprimax.dto.response.GetDepartment;
import com.example.smartemployee.employeeprimax.dto.response.IdentityResponse;
import com.example.smartemployee.employeeprimax.services.DepartmentService;
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
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
    private final DepartmentService departmentService;


    @PostMapping("/create")
    public ResponseEntity<IdentityResponse> createDepartment(@RequestBody @Valid CreateDepartment createDepartment) {
        return new ResponseEntity(departmentService.createDepartment(createDepartment), HttpStatus.CREATED);
    }

    @GetMapping("/show-all/employee/by-department/{id}")
    public DepartmentListResponse getEmployeeUnderDepartment(@PathVariable String id) {
        return departmentService.getCheckDepartmentEmployee(id);
    }

    @PutMapping("update-by/{id}")
    public ResponseEntity<Void> updateCalendar(@PathVariable String id,
                                               @RequestBody @Valid UpdateDepartment updateDepartment) {
        departmentService.updateDepartmentBy(id, updateDepartment);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/view-list")
    public List<GetDepartment> getDepartmentsList(){
        return departmentService.getMyDepartmentList();
    }

    @GetMapping("/{id}")
    public DepartmentResponse getDepartmentList(@PathVariable String id) {
        return departmentService.getDepartment(id);
    }


}
