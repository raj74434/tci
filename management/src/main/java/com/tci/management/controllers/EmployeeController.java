package com.tci.management.controllers;

import com.tci.management.dto.EmployeeBonusList;
import com.tci.management.dto.RequestDto;
import com.tci.management.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/tci/employee-bonus")
    public ResponseEntity<String>  insertEmployes(@RequestBody RequestDto requestDto){

       return new ResponseEntity<>( employeeService.insertEmployees(requestDto), HttpStatus.CREATED);
    }


    @GetMapping("/tci/employee-bonus")
    public ResponseEntity<EmployeeBonusList >  getEmployees(@RequestParam String date){

        return new ResponseEntity<>(employeeService.getEmployeesList(date),HttpStatus.OK);
    }


}
