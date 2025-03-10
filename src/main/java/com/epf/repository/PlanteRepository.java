package com.epf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epf.model.Plante;

@Repository
public class PlanteRepository implements PlanteDAO {
    private final JdbcTemplate jdbcTemplate;

    public PlanteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Plante> findAll() {
        return jdbcTemplate.query("SELECT * FROM Plante", new BeanPropertyRowMapper<>(Plante.class));
    }

    @Override
    public Optional<Plante> findById(int id) {
        return jdbcTemplate.query("SELECT * FROM Plante WHERE id = ?", new BeanPropertyRowMapper<>(Plante.class), id)
                .stream().findFirst();
    }

    @Override
    public void create(Plante plante) {
        jdbcTemplate.update("INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image());
    }

    @Override
    public void save(Plante plante) {
        jdbcTemplate.update("INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image());
    }

    @Override
    public void update(Plante plante) {
        jdbcTemplate.update("UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id = ?",
                plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image(), plante.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Plante WHERE id = ?", id);
    }
}
