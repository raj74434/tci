package com.tci.management.services;

import com.tci.management.dto.*;
import com.tci.management.models.Department;
import com.tci.management.models.Employee;
import com.tci.management.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(){
        months.put("jan","01");
        months.put("feb","02");
        months.put("mar","03");
        months.put("apr","04");
        months.put("may","05");
        months.put("jun","06");
        months.put("jul","07");
        months.put("aug","08");
        months.put("sep","09");
        months.put("oct","10");
        months.put("nov","11");
        months.put("dec","12");
    }

    Map<String,String> months=new HashMap<>();

    Map<String,Integer> currencyList=new HashMap<>();

    @Override
    public String insertEmployees(RequestDto requestDto){
        List<EmployeeDto> employeeDto= requestDto.getEmployees();

        employeeDto.stream().forEach((a)-> {
            a.setExitDate(
                    months.get(a.getExitDate().substring(0, 3)) + "-"
                            + a.getExitDate().substring(4, a.getExitDate().length())
            );
            a.setJoiningDate(months.get(a.getJoiningDate().substring(0, 3)) + "-"
                    + a.getJoiningDate().substring(4, a.getJoiningDate().length()));
        });
        List<Employee> employees=new ArrayList<>();

        employeeDto.stream().forEach((a)-> {
                    Employee emp = new Employee();
                    emp.setEmpName(a.getEmpName());
                    Department dep= new Department();
                    dep.setDepartmentName(a.getDepartment());
                    emp.setDepartment(dep);
                    emp.setAmount(a.getAmount());
                    emp.setCurrency(a.getCurrency());

            emp.setJoiningDate(LocalDate.of( Integer.parseInt(a.getJoiningDate().substring(6, 10))
                    , Integer.parseInt(a.getJoiningDate().substring(0, 2)),
                       Integer.parseInt(a.getJoiningDate().substring(3, 5))
                    ));

            emp.setExitDate(LocalDate.of( Integer.parseInt(a.getExitDate().substring(6, 10))
                    , Integer.parseInt(a.getExitDate().substring(0, 2)),
                    Integer.parseInt(a.getExitDate().substring(3, 5))
            ));


                    employees.add(emp);
                }
        );


        employeeRepo.saveAll(employees);
        return "Employees Inserted";
    }

    @Override
    public EmployeeBonusList getEmployeesList(String date){

        EmployeeBonusList employeeBonusList = new EmployeeBonusList();
        try {
            LocalDate localDate = LocalDate.of(Integer.parseInt(date.substring(8, 12))
                    , Integer.parseInt(
                            months.get(date.substring(1, 4))
                    ),
                    Integer.parseInt(date.substring(5, 7))
            );

            List<Employee> empList = employeeRepo.getEmployeesByDate(localDate);





            int[] place = {0};


            empList.stream().forEach((e) -> {

                if (!currencyList.containsKey(e.getCurrency())) {
                    currencyList.put(e.getCurrency(), place[0]);
                    place[0] = place[0] + 1;

                    

                    CurrencyResponseDto currencyResponseDto = new CurrencyResponseDto();

                    EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
                    employeeResponseDto.setEmpName(e.getEmpName());
                    employeeResponseDto.setAmount(e.getAmount());


                    List<EmployeeResponseDto> employeesListOfBonus = new ArrayList<>();
                    employeesListOfBonus.add(employeeResponseDto);
                    currencyResponseDto.setEmployees(employeesListOfBonus);
                    currencyResponseDto.setCurrency(e.getCurrency());


                    List<CurrencyResponseDto> CurrencyResponseDtoList = employeeBonusList.getData();

                    CurrencyResponseDtoList.add(currencyResponseDto);
                    employeeBonusList.setData(CurrencyResponseDtoList);

                } else {

                    EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
                    employeeResponseDto.setEmpName(e.getEmpName());
                    employeeResponseDto.setAmount(e.getAmount());
                    Integer currentPlace = currencyList.get(e.getCurrency());
                    employeeBonusList.getData().get(currentPlace).getEmployees().add(employeeResponseDto);

                }


            });

            employeeBonusList.getData().stream().forEach((e) -> {
                List<EmployeeResponseDto> employeesForSort = e.getEmployees();
                Collections.sort(employeesForSort, (a, b) -> a.getEmpName().compareTo(b.getEmpName()));
            });

            Collections.sort(employeeBonusList.getData(), (a, b) -> a.getCurrency().compareTo(b.getCurrency()));
        }
        catch (Exception exp){
            employeeBonusList.setErrorMessage(exp.getMessage());
            return employeeBonusList;
        }

        return employeeBonusList;
    }


}
