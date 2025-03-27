package com.example.apifull_security.controller;

import com.example.apifull_security.dao.FunkoDAO;
import com.example.apifull_security.entity.Funko;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/funko-api")
public class FunkoController {


    private static final Logger logger = LoggerFactory.getLogger(FunkoController.class);

    private final FunkoDAO funkoDAO;

    @Autowired
    public FunkoController(FunkoDAO theFunkoDAO) {
        this.funkoDAO = theFunkoDAO;
    }

    @GetMapping("/funko")
    public List<Funko> findAll() {
        logger.info("Recuperando todos los Funkos");
        return funkoDAO.findAll();
    }

    @GetMapping("/funko/{funkoId}")
    public Funko getFunko(@PathVariable int funkoId) {
        logger.info("Buscando Funko con ID: {}", funkoId);
        Funko funko = this.funkoDAO.findById(funkoId);

        if (funko == null) {
            logger.error("Funko con ID {} no encontrado", funkoId);
            throw new RuntimeException("Funko with ID: " + funkoId + " not found.");
        }
        return funko;
    }

    @PostMapping("/funko")
    public Funko addFunko(@RequestBody Funko theFunko) {
        logger.info("Creando nuevo Funko: {}", theFunko);
        this.funkoDAO.save(theFunko);
        return theFunko;
    }

    @PutMapping("/funko")
    public Funko updateFunko(@RequestBody Funko theFunko) {
        logger.info("Actualizando Funko: {}", theFunko);
        this.funkoDAO.update(theFunko);
        return theFunko;
    }

    @DeleteMapping("/funko/{funkoId}")
    public String deleteFunko(@PathVariable int funkoId) {
        logger.warn("Eliminando Funko con ID: {}", funkoId);
        this.funkoDAO.delete(funkoId);
        logger.info("Funko con ID {} eliminado exitosamente", funkoId);
        return "Deleted Funko with ID: " + funkoId;
    }
}