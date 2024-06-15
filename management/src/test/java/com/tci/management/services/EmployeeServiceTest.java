package com.tci.management.services;

import com.tci.management.dto.EmployeeBonusList;
import com.tci.management.dto.EmployeeDto;
import com.tci.management.dto.RequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testInsertEmployees(){
        RequestDto requestDto=new RequestDto();
        List<EmployeeDto> employees=requestDto.getEmployees();
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setEmpName("raj singh");
        employeeDto.setDepartment("accounts");
        employeeDto.setAmount((double)5000);
        employeeDto.setCurrency("INR");
        employeeDto.setJoiningDate("may-20-2000");
        employeeDto.setExitDate("may-20-2010");

        EmployeeDto employeeDto2=new EmployeeDto();
        employeeDto2.setEmpName("susan");
        employeeDto2.setDepartment("IT");
        employeeDto2.setAmount((double)700);
        employeeDto2.setCurrency("USD");
        employeeDto2.setJoiningDate("jan-01-2022");
        employeeDto2.setExitDate("dec-31-2022");

        employees.add(employeeDto);
        employees.add(employeeDto2);
        requestDto.setEmployees(employees);
        String result = employeeService.insertEmployees(requestDto);
        assertEquals("Employees Inserted", result);


    }


    @Test
    public void getEmployeesList(){
        EmployeeBonusList employeeBonusList=employeeService.getEmployeesList("/may-20-2009");
        System.out.println(employeeBonusList);
        assertNotNull(employeeBonusList.getData().size());
        assertEquals(1, employeeBonusList.getData().size());
    }

}
