package com.example.smartemployee.employeeprimax.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    private String id;

    @NotNull
    @Column(nullable = false)
    @Length(min = 1, max = 5)
    private String code;
    @NotNull
    @Column(nullable = false)
    @Length(min = 1, max = 30)
    private String name;
    private LocalDate joiningDate;
    private LocalDate dateOfBirth;
    @NotNull
    @Column(nullable = false)
    @Length(min = 1, max = 20)
    private String designation;
    private String basic;
    private GenderName gender;
    @ManyToOne
    private Department department;



}
