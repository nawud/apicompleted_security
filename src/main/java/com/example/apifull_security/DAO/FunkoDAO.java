package com.example.apifull_security.DAO;


import com.example.funkoapi.entity.Funko;

import java.util.List;

public interface FunkoDAO {


        List<Funko> findAll();


        Funko findById(Long id);


        Funko save(Funko funko);


        void deleteById(Long id);
    }

