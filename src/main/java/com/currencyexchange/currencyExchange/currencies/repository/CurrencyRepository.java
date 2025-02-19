package com.currencyexchange.currencyExchange.currencies.repository;

import com.currencyexchange.currencyExchange.currencies.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {



    Optional<Currency>  findByFromCurrencyAndToCurrencyAndDate(String from, String to, LocalDate date);
}
