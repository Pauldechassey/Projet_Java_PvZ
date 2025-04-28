package com.epf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.dto.PlanteDTO;
import com.epf.model.Plante;
import com.epf.service.PlanteService;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteService planteService;

    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    @GetMapping
    public List<PlanteDTO> getAllPlantes() {
        return planteService.findAll().stream()
            .map(PlanteDTO::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PlanteDTO getPlanteById(@PathVariable("id") int id) { 
        return new PlanteDTO(planteService.findById(id));
    }

    @PostMapping
    public void createPlante(@RequestBody PlanteDTO planteDTO) {
        planteService.create(planteDTO.toEntity());
    }

    @PutMapping("/{id}")
    public void updatePlante(@PathVariable("id") int id, @RequestBody PlanteDTO planteDTO) { 
        Plante plante = planteDTO.toEntity();
        plante.setId(id);
        planteService.update(plante);
    }

    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable("id") int id) { 
        planteService.delete(id);
    }
}
