package com.tci.management.dto;

import com.tci.management.models.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class RequestDto {


    private List<EmployeeDto> employees=new ArrayList<>();

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
