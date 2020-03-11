package com.example.smartemployee.employeeprimax.dto.request;

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
public class UpdateEmployee {

    private LocalDate joiningDate;
    @Size(min = 5, max = 20)
    private String designation;
    private String basic;



}
