package com.example.currencyconverter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Valute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private int numCode;

    private String charCode;

    private BigDecimal nominal;

    private String name;

    private BigDecimal value;

    private LocalDate date;

    public Valute(int numCode, String charCode, BigDecimal nominal, String name, BigDecimal value, LocalDate date) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        this.date = date;
    }
}
