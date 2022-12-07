package com.example.currencyconverter.services;

import com.example.currencyconverter.models.Convert;
import com.example.currencyconverter.models.Valute;
import com.example.currencyconverter.repos.ConvertRepo;
import com.example.currencyconverter.repos.ValuteRepo;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ConvertService.class)
class ConvertServiceTest {

    @Autowired
    ConvertService convertService;

    @MockBean
    ConvertRepo convertRepo;

    @MockBean
    ValuteRepo valuteRepo;

    @Test
    void getConvert() {
        Convert convert = new Convert(1L, LocalDate.of(2022, 12, 7), "TRY", "JPY", new BigDecimal(1), new BigDecimal(1), new BigDecimal(1));
        when(convertRepo.findById(1L)).thenReturn(Optional.of(convert));
        assertEquals(convertService.getConvert(1L), convert);
    }

    @Test
    void getConvertShouldThrowException(){
        when(convertRepo.findById(1L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> convertService.getConvert(1L));
    }

    @Test
    void addConvert(){
        Convert convert = new Convert(1L, LocalDate.of(2022, 12, 7), "TRY", "JPY", new BigDecimal(1), new BigDecimal(1), new BigDecimal(1));
        Valute valute = new Valute(1L, 1, "TRY", new BigDecimal(10), "Турецкая лира",  new BigDecimal(10), LocalDate.of(2022,12,7));
        Valute valute2 = new Valute(2L, 2, "JPY", new BigDecimal(10), "Японская йена",  new BigDecimal(10), LocalDate.of(2022,12,7));
        when(valuteRepo.findFirstByCharCodeAndDate(convert.getFromValute(), LocalDate.of(2022,12,7))).thenReturn(valute);
        when(valuteRepo.findFirstByCharCodeAndDate(convert.getToValute(), LocalDate.of(2022,12,7))).thenReturn(valute2);
        when(convertRepo.save(convert)).thenReturn(convert);
        assertEquals(convertService.addConvert(convert), convert);
    }
}