package com.example.currencyconverter.services;

import com.example.currencyconverter.models.Convert;
import com.example.currencyconverter.models.Valute;
import com.example.currencyconverter.repos.ConvertRepo;
import com.example.currencyconverter.repos.ValuteRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
public class ConvertService {

    private final ConvertRepo convertRepo;
    private final ValuteRepo valuteRepo;

    public ConvertService(ConvertRepo convertRepo, ValuteRepo valuteRepo) {
        this.convertRepo = convertRepo;
        this.valuteRepo = valuteRepo;
    }

    public List<Convert> getAllConverts(){
        return convertRepo.findAll();
    }

    public Convert getConvert(Long id){
        return convertRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Convert addConvert(Convert convert){
        LocalDate date = LocalDate.now();
        Valute fromValute = valuteRepo.findFirstByCharCodeAndDate(convert.getFromValute(), date);
        Valute toValute = valuteRepo.findFirstByCharCodeAndDate(convert.getToValute(), date);
        BigDecimal course = fromValute.getValue().divide(fromValute.getNominal()).divide(toValute.getValue().divide(toValute.getNominal()), 3, RoundingMode.HALF_UP);
        BigDecimal result = course.multiply(convert.getFromValuteAmount());
        convert.setDate(date);
        convert.setCourse(course);
        convert.setResult(result);
        return convertRepo.save(convert);
    }

}
