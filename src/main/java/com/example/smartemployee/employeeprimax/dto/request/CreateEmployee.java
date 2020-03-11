package com.example.smartemployee.employeeprimax.dto.request;

import com.example.smartemployee.employeeprimax.domain.Department;
import com.example.smartemployee.employeeprimax.domain.GenderName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployee {

    @Size(min = 1, max = 5)
    private String code;
    @Size(min = 1, max = 30)
    private String name;
    private LocalDate joiningDate;
    private LocalDate dateOfBirth;
    @Size(min = 1, max = 20)
    private String designation;
    private String basic;
    private GenderName gender;
    private String departmentId;

}
