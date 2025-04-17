package com.epf.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.epf.dao.PlanteDAO;
import com.epf.model.Plante;

@Service
public class PlanteService {

    private final PlanteDAO planteDAO;

    public PlanteService(PlanteDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    public List<Plante> findAll() {
        return planteDAO.findAll();
    }

    public Plante findById(int id) {
        return planteDAO.findById(id);
    }

    public void create(Plante plante) {
        planteDAO.create(plante);
    }

    public void update(Plante plante) {
        planteDAO.update(plante);
    }

    public void delete(int id) {
        planteDAO.delete(id);
    }
}
