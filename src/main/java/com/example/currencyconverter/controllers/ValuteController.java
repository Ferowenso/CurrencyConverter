package com.example.currencyconverter.controllers;

import com.example.currencyconverter.models.Valute;
import com.example.currencyconverter.services.ValuteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/valutes")
public class ValuteController {

    private final ValuteService valuteService;

    public ValuteController(ValuteService valuteService) {
        this.valuteService = valuteService;
    }

    @GetMapping()
    ResponseEntity<List<Valute>> getNowCourse() throws IOException {
        return new ResponseEntity<>(valuteService.getNowCourse(), HttpStatus.OK);
    }

    @GetMapping("{date}")
    ResponseEntity<List<Valute>> getCourseByDate(@PathVariable LocalDate date){
        return new ResponseEntity<>(valuteService.getCourseByDate(date), HttpStatus.OK);
    }

}
