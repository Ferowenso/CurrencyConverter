package com.example.currencyconverter.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Convert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;

    @NotNull
    private String fromValute;

    @NotNull
    private String toValute;

    @NotNull
    private BigDecimal fromValuteAmount;

    private BigDecimal course;

    private BigDecimal result;
}
