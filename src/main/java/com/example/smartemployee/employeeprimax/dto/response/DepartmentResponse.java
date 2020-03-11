package com.example.smartemployee.employeeprimax.dto.response;

import lombok.*;

import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DepartmentResponse {

    @Size(min = 1, max = 5)
    private String code;
    @Size(min = 1, max = 30)
    private String name;
    private boolean active;
}
