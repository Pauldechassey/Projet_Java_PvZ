package com.epf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.model.Plante;
import com.epf.repository.PlanteRepository;

@Service
public class PlanteServiceImpl implements PlanteService {

    private final PlanteRepository planteRepository;

    public PlanteServiceImpl(PlanteRepository planteRepository) {
        this.planteRepository = planteRepository;
    }

    @Override
    public List<Plante> findAll() {
        return planteRepository.findAll();
    }

    @Override
    public Plante findById(int id) {
        return planteRepository.findById(id).orElse(null);
    }


    @Override
    public void create(Plante plante) {
        planteRepository.create(plante);
    }

    @Override
    public void update(Plante plante) {
        planteRepository.update(plante);
    }

    @Override
    public void delete(int id) {
        planteRepository.delete(id);
    }
}
