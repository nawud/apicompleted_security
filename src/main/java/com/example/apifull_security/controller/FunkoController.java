package com.example.apifull_security.controller;

import com.example.apifull_security.entity.Funko;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FunkoController {


    @GetMapping("/funko")
    public List<Funko> funkoList;


    @GetMapping("/funko/{funkoId}")
    public Funko getFunko(@PathVariable int funkoId) {

        for (Funko funko: this.funkoList()) {

            if (funko.getId() == funkoId) { return funko; }

        } return null;

    }

    @PostMapping("/funko")
    public Funko addFunko(@RequestBody Funko theFunko) {

        funkoList.add(theFunko);

        return theFunko;

    }

    @PutMapping("/funko")
    public Funko updateFunko(@RequestBody Funko theFunko) {

        for (Funko funko: funkoList) {

            if (funko.getId() == theFunko.getId()) {

                funko.setName(theFunko.getName());
                funko.setDescription(theFunko.getDescription());
                funko.setPrice(theFunko.getPrice());

            }

        } return theFunko;

    }

    @DeleteMapping("/funko/{funkoId}")
    public String deleteFunko(@PathVariable int funkoId) {

        this.funkoList.removeIf(f -> f.getId() == funkoId);

        return "Borrado Funko con ID: " + funkoId;

    }

}