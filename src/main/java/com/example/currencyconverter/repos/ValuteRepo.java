package com.example.currencyconverter.repos;

import com.example.currencyconverter.models.Valute;
import com.example.currencyconverter.pojo.ValutePojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ValuteRepo extends JpaRepository<Valute, Long> {

    boolean existsByDate(LocalDate date);

    List<Valute> findAllByDate(LocalDate date);

    Valute findFirstByCharCodeAndDate(String charCode, LocalDate date);


}
