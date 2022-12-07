package com.example.currencyconverter.services;

import com.example.currencyconverter.models.Convert;
import com.example.currencyconverter.models.Statistic;
import com.example.currencyconverter.repos.ConvertRepo;
import com.example.currencyconverter.repos.StatisticRepo;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = StatisticService.class)
class StatisticServiceTest {

    @Autowired
    StatisticService statisticService;

    @MockBean
    StatisticRepo statisticRepo;

    @MockBean
    ConvertRepo convertRepo;

    @Test
    void addStatistic() {
        List<Convert> converts = new ArrayList<>();
        Statistic statistic = new Statistic(1L, "TRY", "JPY", 2, new BigDecimal(1));
        converts.add(new Convert(1L, LocalDate.of(2022, 12, 7), "TRY", "JPY", new BigDecimal(1), new BigDecimal(1), new BigDecimal(1)));
        converts.add(new Convert(2L, LocalDate.of(2022, 12, 7), "TRY", "JPY", new BigDecimal(2), new BigDecimal(1), new BigDecimal(2)));
        when(convertRepo.findAllByFromValuteAndToValute("TRY","JPY")).thenReturn(converts);
        when(statisticRepo.save(statistic)).thenReturn(statistic);
        assertEquals(statisticService.addStatistic(statistic), statistic);
    }

    @Test
    void addStatisticShouldThrowException() {
        List<Convert> converts = new ArrayList<>();
        Statistic statistic = new Statistic(1L, "TRY", "JPY", 2, new BigDecimal(1));
        when(convertRepo.findAllByFromValuteAndToValute("TRY","JPY")).thenReturn(converts);
        assertThrows(EntityNotFoundException.class ,() -> statisticService.addStatistic(statistic));
    }
}