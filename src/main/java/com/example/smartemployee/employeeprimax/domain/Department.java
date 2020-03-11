package com.example.smartemployee.employeeprimax.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DEPARTMENT")
public class Department {

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
    private boolean active;



}
