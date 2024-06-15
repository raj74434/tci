package com.tci.management.services;

import com.tci.management.dto.EmployeeBonusList;
import com.tci.management.dto.RequestDto;
import com.tci.management.models.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {

    public String insertEmployees(RequestDto requestDto);

    public EmployeeBonusList getEmployeesList(String date);

}
