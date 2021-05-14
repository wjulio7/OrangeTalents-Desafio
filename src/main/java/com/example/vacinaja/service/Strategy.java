package com.example.vacinaja.service;

import com.example.vacinaja.enums.StrategyName;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;

public interface Strategy {
    String getResponse();
    LocalDate getGenericResponse(LocalDate t);
    StrategyName init();
}
