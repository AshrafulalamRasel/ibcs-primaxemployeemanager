package com.example.smartemployee.employeeprimax.dto.response;

import com.example.smartemployee.employeeprimax.domain.Department;
import com.example.smartemployee.employeeprimax.domain.GenderName;
import lombok.*;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeListResponse {

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
    private List<DepartmentResponse> departmentList;

}
