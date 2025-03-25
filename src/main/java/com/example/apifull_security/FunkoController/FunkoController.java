package com.example.apifull_security.FunkoController;

import com.example.funkoapi.entity.Funko;
import com.example.apifull_security.service.FunkoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funkos")
public class FunkoController {

    @Autowired
    private FunkoService funkoService;


    @GetMapping
    public ResponseEntity<List<Funko>> getAllFunkos() {
        List<Funko> funkos = funkoService.findAll();
        return new ResponseEntity<>(funkos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Funko> getFunkoById(@PathVariable Long id) {
        Funko funko = funkoService.findById(id);
        if (funko != null) {
            return new ResponseEntity<>(funko, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Crear un nuevo Funko
    @PostMapping
    public ResponseEntity<Funko> createFunko(@RequestBody Funko funko) {
        Funko savedFunko = funkoService.save(funko);
        return new ResponseEntity<>(savedFunko, HttpStatus.CREATED);
    }

    // Actualizar un Funko existente
    @PutMapping("/{id}")
    public ResponseEntity<Funko> updateFunko(@PathVariable Long id, @RequestBody Funko funkoDetails) {
        Funko funko = funkoService.findById(id);
        if (funko != null) {
            funko.setName(funkoDetails.getName());
            funko.setDescription(funkoDetails.getDescription());
            funko.setPrice(funkoDetails.getPrice());

            Funko updatedFunko = funkoService.save(funko);
            return new ResponseEntity<>(updatedFunko, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar un Funko
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFunko(@PathVariable Long id) {
        Funko funko = funkoService.findById(id);
        if (funko != null) {
            funkoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}