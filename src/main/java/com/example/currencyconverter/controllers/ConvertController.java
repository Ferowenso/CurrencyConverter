package com.example.currencyconverter.controllers;

import com.example.currencyconverter.models.Convert;
import com.example.currencyconverter.services.ConvertService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/converts")
public class ConvertController {

    private final ConvertService convertService;

    public ConvertController(ConvertService convertService) {
        this.convertService = convertService;
    }

    @GetMapping
    ResponseEntity<List<Convert>> getAllConverts(){
        return new ResponseEntity<>(convertService.getAllConverts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<Convert> getConvert(@PathVariable Long id){
        return new ResponseEntity<>(convertService.getConvert(id), HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Convert> addConvert(@RequestBody @Valid Convert convert){
        return new ResponseEntity<>(convertService.addConvert(convert), HttpStatus.CREATED);
    }
}
