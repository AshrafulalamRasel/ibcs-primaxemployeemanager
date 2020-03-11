package com.example.smartemployee.employeeprimax.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDepartment {

    @Size(min = 1, max = 5)
    private String code;
    @Size(min = 1, max = 20)
    private String name;
    private boolean active;
}
