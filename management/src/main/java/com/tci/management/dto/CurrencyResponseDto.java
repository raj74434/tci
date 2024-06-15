package com.tci.management.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CurrencyResponseDto {
    private String currency;

    private List<EmployeeResponseDto> employees=new ArrayList<>();

    @Override
    public String toString() {
        return "CurrencyResponseDto{" +
                "currency='" + currency + '\'' +
                ", employees=" + employees +
                '}';
    }
}
