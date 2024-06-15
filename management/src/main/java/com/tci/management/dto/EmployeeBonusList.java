package com.tci.management.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeBonusList {

    private String errorMessage ;

    private List<CurrencyResponseDto>  data=new ArrayList<>();


    @Override
    public String toString() {
        return "EmployeeBonusList{" +
                "errorMessage='" + errorMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
