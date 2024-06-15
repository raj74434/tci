package com.tci.management.repositories;

import com.tci.management.dto.EmployeeBonusList;
import com.tci.management.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


    @Query("select e from Employee as e where e.joiningDate <= :localDate AND e.exitDate >= :localDate ")
    public List<Employee> getEmployeesByDate(@Param("localDate") LocalDate localDate);

}
