package com.tci.management.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private String empName;

    @OneToOne(cascade = CascadeType.ALL)
    private Department department;

    private Double amount ;
    private String currency;
    private LocalDate joiningDate;
    private LocalDate exitDate;



}
