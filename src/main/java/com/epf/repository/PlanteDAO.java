package com.epf.repository;

import java.util.List;
import java.util.Optional;

import com.epf.model.Plante;

public interface PlanteDAO {
    List<Plante> findAll();
    Optional<Plante> findById(int id);
    void save(Plante plante);
    void update(Plante plante);
    void delete(int id);
}
