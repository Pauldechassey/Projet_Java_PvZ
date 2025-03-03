package com.epf.controller;

import com.epf.repository.PlanteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plante")
public class PlanteController {

    private final PlanteRepository planteRepository;

    public PlanteController(PlanteRepository planteRepository) {
        this.planteRepository = planteRepository;
    }

    @GetMapping
    public List<Map<String, Object>> getPlantes() {
        return planteRepository.findAllPlante();
    }
}