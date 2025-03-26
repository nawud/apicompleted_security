package com.example.apifull_security.controller;

import com.example.apifull_security.dao.FunkoDAO;
import com.example.apifull_security.entity.Funko;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FunkoController {

    private FunkoDAO funkoDAO;

    @Autowired
    public FunkoController( FunkoDAO theFunkoDAO ) { funkoDAO = theFunkoDAO; }

    @GetMapping("/funko")
    public List<Funko> findAll() { return funkoDAO.findAll(); }

    @GetMapping("/funko/{funkoId}")
    public Funko getFunko(@PathVariable int funkoId) {

        Funko funko = this.funkoDAO.findById(funkoId);

        if (funko == null) {

            throw new RuntimeException("Funko with ID: " + funkoId + " not found.")

        } return funko;

    }

    @PostMapping("/funko")
    public Funko addFunko(@RequestBody Funko theFunko) {

        this.funkoDAO.save(theFunko);

        return theFunko;

    }

    @PutMapping("/funko")
    public Funko updateFunko(@RequestBody Funko theFunko) {

        this.funkoDAO.update(theFunko);

        return theFunko;

    }

    @DeleteMapping("/funko/{funkoId}")
    public String deleteFunko(@PathVariable int funkoId) {

        this.funkoDAO.delete(funkoId);

        return "Deleted Funko with ID: " + funkoId;

    }

}