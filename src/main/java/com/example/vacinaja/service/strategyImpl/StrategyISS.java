package com.example.vacinaja.service.strategyImpl;


import com.example.vacinaja.enums.StrategyName;
import com.example.vacinaja.service.Strategy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class StrategyISS implements Strategy {

    @Override
    public String getResponse() {
        return "I am instance of StrategyISS";    }

    @Override//São Paulo, cuja alíquota é de 2%
    public LocalDate getGenericResponse(LocalDate valor) {
        return  valor;
    }

    @Override
    public StrategyName init() {
        return StrategyName.StrategyISS;
    }
}
