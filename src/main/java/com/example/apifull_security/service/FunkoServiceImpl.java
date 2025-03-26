package com.example.funkoapi.service;

import com.example.apifull_security.dao.FunkoDAO;
import com.example.apifull_security.service.FunkoService;
import com.example.funkoapi.entity.Funko;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunkoServiceImpl implements FunkoService {

    @Autowired
    private FunkoDAO funkoDAO;

    @Override
    public List<Funko> getAllFunkos() {
        return funkoDAO.findAll();
    }

    @Override
    public Funko getFunkoById(Long id) {
        return funkoDAO.findById(id);
    }

    @Override
    public Funko createFunko(Funko funko) {
        return funkoDAO.save(funko);
    }

    @Override
    public Funko updateFunko(Long id, Funko funkoDetails) {
        Funko funko = funkoDAO.findById(id);
        if (funko == null) {
            throw new RuntimeException("Funko not found with id: " + id);
        }
        funko.setName(funkoDetails.getName());
        funko.setDescription(funkoDetails.getDescription());
        funko.setPrice(funkoDetails.getPrice());
        return funkoDAO.save(funko);
    }

    @Override
    public void deleteFunko(Long id) {
        funkoDAO.deleteById(id);
    }
}