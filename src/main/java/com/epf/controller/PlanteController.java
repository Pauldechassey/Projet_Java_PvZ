package com.epf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.model.Plante;
import com.epf.repository.PlanteRepository;

@RestController
@RequestMapping("/plante")
public class PlanteController {

    private final PlanteRepository planteRepository;

    public PlanteController(PlanteRepository planteRepository) {
        this.planteRepository = planteRepository;
    }

    @GetMapping
    public List<Plante> getPlantes() {
        return planteRepository.findAll(); // Utilisation de findAll() au lieu de findAllPlante()
    }
}