package com.epf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.epf.dto.PlanteDTO;
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
    public List<PlanteDTO> getAllPlantes() {
        return planteService.findAll().stream()
            .map(PlanteDTO::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PlanteDTO getPlanteById(@PathVariable int id) {
        return new PlanteDTO(planteService.findById(id));
    }

    @PostMapping
    public void createPlante(@RequestBody PlanteDTO planteDTO) {
        Plante plante = planteDTO.toEntity();
        planteService.create(plante);
    }

    @PutMapping("/{id}")
    public void updatePlante(@PathVariable int id, @RequestBody PlanteDTO planteDTO) {
        Plante plante = planteDTO.toEntity();
        plante.setId(id); 
        planteService.update(plante);
    }

    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable int id) {
        planteService.delete(id);
    }
}
