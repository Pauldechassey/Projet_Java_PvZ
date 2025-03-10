package com.epf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.model.Plante;
import com.epf.service.PlanteService;

@RestController
@RequestMapping("/plante")
public class PlanteController {

    private final PlanteService planteService;

    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    @GetMapping
    public List<Plante> getAllPlantes() {
        return planteService.findAll();
    }

    @GetMapping("/{id}")
    public Plante getPlanteById(@PathVariable int id) {
        return planteService.findById(id);
    }

    @PostMapping
    public void createPlante(@RequestBody Plante plante) {
        planteService.create(plante);
    }

    @PutMapping("/{id}")
    public void updatePlante(@PathVariable int id, @RequestBody Plante plante) {
        plante.setId(id); // On force l'ID pour éviter les incohérences
        planteService.update(plante);
    }

    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable int id) {
        planteService.delete(id);
    }
}
