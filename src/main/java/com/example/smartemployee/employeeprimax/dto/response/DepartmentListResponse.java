package com.example.smartemployee.employeeprimax.dto.response;

import com.example.smartemployee.employeeprimax.domain.Department;
import com.example.smartemployee.employeeprimax.domain.Employee;
import lombok.*;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Data
@Builder
public class DepartmentListResponse {
  @Size(min = 1, max = 5)
  private String code;
  @Size(min = 1, max = 30)
  private String name;
  private boolean active;
  private List<EmployeeResponses> employeeList;
}
