package com.example.currencyconverter.repos;

import com.example.currencyconverter.models.Convert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConvertRepo extends JpaRepository<Convert, Long> {

    public List<Convert> findAllByFromValuteAndToValute(String fromValute, String toValute);

}
