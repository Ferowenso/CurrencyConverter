package com.example.currencyconverter.services;

import com.example.currencyconverter.models.Valute;
import com.example.currencyconverter.pojo.ValCursPojo;
import com.example.currencyconverter.pojo.ValutePojo;
import com.example.currencyconverter.repos.ValuteRepo;
import com.example.currencyconverter.utils.CbrRequest;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValuteService {

    private final ValuteRepo valuteRepo;

    private final OkHttpClient client = new OkHttpClient();

    public ValuteService(ValuteRepo valuteRepo) {
        this.valuteRepo = valuteRepo;
    }

    public List<Valute> getNowCourse() throws IOException {
        LocalDate date = LocalDate.now();
        if (!valuteRepo.existsByDate(date)){
            return valuteRepo.saveAll(CbrRequest.getValutes().stream()
                    .map(x -> new Valute(x.getNumCode(), x.getCharCode(), new BigDecimal(x.getNominal()), x.getName(), new BigDecimal(x.getValue().replace(",", ".")), date))
                    .toList());
        }
        else {
            return valuteRepo.findAllByDate(date);
        }
    }

    public List<Valute> getCourseByDate(LocalDate date){
        return valuteRepo.findAllByDate(date);
    }
}
