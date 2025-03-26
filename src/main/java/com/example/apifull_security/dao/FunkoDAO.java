package com.example.apifull_security.dao;

import com.example.apifull_security.entity.Funko;
import java.util.List;

public interface FunkoDAO {

        void save(Funko theFunko);

        Funko findById(int id);

        List<Funko> findAll();

        void update(Funko theFunko);

        void delete(int id);
}

