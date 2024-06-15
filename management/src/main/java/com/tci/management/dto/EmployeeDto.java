package com.tci.management.dto;

import com.tci.management.models.Department;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {

    private String empName;
    private String department;
    private Double amount ;
    private String currency;
    private String joiningDate;
    private String exitDate;


    @Override
    public String toString() {
        return "EmployeeDto{" +
                "empName='" + empName + '\'' +
                ", department='" + department + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", joiningDate='" + joiningDate + '\'' +
                ", exitDate='" + exitDate + '\'' +
                '}';
    }
}
