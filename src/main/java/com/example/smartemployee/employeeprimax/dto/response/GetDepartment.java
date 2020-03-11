package com.example.smartemployee.employeeprimax.dto.response;

import lombok.*;

import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetDepartment {
    private String id;
    @Size(min = 1, max = 30)
    private String name;
}
