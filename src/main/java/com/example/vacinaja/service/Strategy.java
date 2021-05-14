package com.example.vacinaja.service;

import com.example.vacinaja.enums.StrategyName;

public interface Strategy {
    String getResponse();
    Double getGenericResponse(Double t);
    StrategyName init();
}
