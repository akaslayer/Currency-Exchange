package com.currencyexchange.currencyExchange.currencies.service;

import com.currencyexchange.currencyExchange.currencies.dto.CurrencyConversionRequestDto;
import com.currencyexchange.currencyExchange.currencies.dto.CurrencyConversionResponseDto;
import org.example.ExchangeRequest;
import org.example.ExchangeResponse;

public interface CurrencyServices {
    int convertCurrency(CurrencyConversionRequestDto user);

    ExchangeResponse getExchangeRate(ExchangeRequest data);
}
