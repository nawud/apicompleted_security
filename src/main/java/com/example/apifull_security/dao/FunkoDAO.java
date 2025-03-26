package com.example.apifull_security.dao;

import com.example.apifull_security.entity.Funko;
import java.util.List;

public interface FunkoDAO {

        List<Funko> findAll();

        Funko findById(int id);

        Funko save(Funko funko);

        void deleteById(int id);

}

