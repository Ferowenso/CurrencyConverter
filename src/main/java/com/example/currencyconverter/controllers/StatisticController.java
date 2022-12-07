package com.example.currencyconverter.controllers;


import com.example.currencyconverter.models.Statistic;
import com.example.currencyconverter.services.StatisticService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping
    public ResponseEntity<List<Statistic>> getAllStatistics(){
        return new ResponseEntity<>(statisticService.getAllStatistics(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Statistic> addStatistic(@RequestBody @Valid Statistic statistic){
        return new ResponseEntity<>(statisticService.addStatistic(statistic), HttpStatus.CREATED);
    }

}
