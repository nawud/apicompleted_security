package com.example.apifull_security.service;

import com.example.funkoapi.entity.Funko;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface FunkoService {

    @Transactional(readOnly = true)
    List<Funko> getAllFunkos();

    @Transactional(readOnly = true)
    Funko getFunkoById(Long id);

    @Transactional
    Funko createFunko(Funko funko);

    @Transactional
    Funko updateFunko(Long id, Funko funkoDetails);

    @Transactional
    void deleteFunko(Long id);
}