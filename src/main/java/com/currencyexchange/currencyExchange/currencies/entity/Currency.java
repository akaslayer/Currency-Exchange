package com.currencyexchange.currencyExchange.currencies.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currencies_id_gen")
    @SequenceGenerator(name = "currencies_id_gen", sequenceName = "currencies_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "from_currency")
    private String fromCurrency;

    @Column(name = "to_Currency")
    private String toCurrency;

    @Column(name = "rate")
    private int rate;

    @Column(name = "date")
    private LocalDate date;


    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;


    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }


}
