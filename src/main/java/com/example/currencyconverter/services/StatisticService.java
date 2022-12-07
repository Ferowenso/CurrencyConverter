package com.example.currencyconverter.services;

import com.example.currencyconverter.models.Convert;
import com.example.currencyconverter.models.Statistic;
import com.example.currencyconverter.repos.ConvertRepo;
import com.example.currencyconverter.repos.StatisticRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.util.List;

@Service
public class StatisticService {

    private final StatisticRepo statisticRepo;
    private final ConvertRepo convertRepo;

    public StatisticService(StatisticRepo statisticRepo, ConvertRepo convertRepo) {
        this.statisticRepo = statisticRepo;
        this.convertRepo = convertRepo;
    }

    public List<Statistic> getAllStatistics(){
        return statisticRepo.findAll();
    }

    public Statistic addStatistic(Statistic statistic){
        List<Convert> converts = convertRepo.findAllByFromValuteAndToValute(statistic.getFromValute(), statistic.getToValute());
        if (converts.isEmpty()){
            throw new EntityNotFoundException();
        }
        else {
            statistic.setConvertCount(converts.size());
            statistic.setAverageCourse(converts.stream().map(x -> x.getCourse()).reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(converts.size())));
            return statisticRepo.save(statistic);
        }

    }


}
