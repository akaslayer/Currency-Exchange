package com.currencyexchange.currencyExchange.currencies.service.impl;


import com.currencyexchange.currencyExchange.currencies.dto.CurrencyConversionRequestDto;
import com.currencyexchange.currencyExchange.currencies.dto.CurrencyConversionResponseDto;
import com.currencyexchange.currencyExchange.currencies.entity.Currency;
import com.currencyexchange.currencyExchange.currencies.repository.CurrencyRepository;
import com.currencyexchange.currencyExchange.currencies.service.CurrencyServices;
import org.example.ExchangeRequest;
import org.example.ExchangeResponse;
import org.example.RequestData;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyServices {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public int convertCurrency(CurrencyConversionRequestDto data) {
        String[] currencies = data.getPair().split("/");
        var currencyData = currencyRepository.findByFromCurrencyAndToCurrencyAndDate(currencies[0],currencies[1],data.getDate()).orElse(null);
        return currencyData.getRate();



//        Currency currencyData = new Currency();
//        currencyData.setAmount(data.getAmount());
//        currencyData.setPair(data.getPair());
//        currencyData.setDate(data.getDate());
//        currencyRepository.save(currencyData);


//        return data.getAmount()*50000;
    }

    @Override
    public ExchangeResponse getExchangeRate(ExchangeRequest data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Integer> processedDataList = new ArrayList<>();
        for(RequestData exchangeData: data.getResultList()){
            LocalDate localDate = LocalDate.parse(exchangeData.getDate(), formatter);
            String[] currencies = exchangeData.getPair().split("/");
            var currencyData = currencyRepository.findByFromCurrencyAndToCurrencyAndDate(currencies[0],currencies[1],localDate).orElse(null);
            if(exchangeData.getAmount().equals("")){
                processedDataList.add(0);
            }else{
                processedDataList.add(currencyData.getRate() * Integer.parseInt(exchangeData.getAmount()));
            }

        }
        ExchangeResponse response = ExchangeResponse.newBuilder()
                .addAllResult(processedDataList)
                .build();
        System.out.println(response);
        return response;
    }
}
