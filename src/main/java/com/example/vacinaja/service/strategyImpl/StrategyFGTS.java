package com.example.vacinaja.service.strategyImpl;


import com.example.vacinaja.enums.StrategyName;
import com.example.vacinaja.service.Strategy;
import org.springframework.stereotype.Service;

@Service
public class StrategyFGTS implements Strategy {

    @Override
    public String getResponse() {
        return "I am instance of StrategyFGTS";
    }

    @Override//tentei tirar redundancias
    public Double getGenericResponse(Double valor) {
        return 8 * valor / 100;
    }

    @Override
    public StrategyName init() {
        return StrategyName.StrategyFGTS;
    }
}