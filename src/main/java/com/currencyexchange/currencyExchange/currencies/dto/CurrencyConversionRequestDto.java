package com.currencyexchange.currencyExchange.currencies.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class CurrencyConversionRequestDto {
    private String pair;
    private int amount;
    private LocalDate date;
}
