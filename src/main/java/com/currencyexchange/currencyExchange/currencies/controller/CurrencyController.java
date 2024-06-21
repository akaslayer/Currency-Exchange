package com.currencyexchange.currencyExchange.currencies.controller;


import com.currencyexchange.currencyExchange.currencies.dto.CurrencyConversionRequestDto;
import com.currencyexchange.currencyExchange.currencies.service.CurrencyServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {
    private final CurrencyServices currencyServices;

    public CurrencyController(CurrencyServices currencyServices) {
        this.currencyServices = currencyServices;
    }

    @PostMapping("/exchange")
    public ResponseEntity<Integer> register(@RequestBody CurrencyConversionRequestDto currencyConversionRequestDto) {
        return ResponseEntity.ok().body(currencyServices.convertCurrency(currencyConversionRequestDto));
    }
}
