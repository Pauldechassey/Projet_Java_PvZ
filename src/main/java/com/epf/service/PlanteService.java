package com.epf.service;

import java.util.List;

import com.epf.model.Plante;

public interface PlanteService {
    List<Plante> findAll();
    Plante findById(int id);
    void create(Plante plante);
    void update(Plante plante);
    void delete(int id);
}
