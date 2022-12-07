package com.example.currencyconverter.repos;

import com.example.currencyconverter.models.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepo extends JpaRepository<Statistic, Long> {
}
