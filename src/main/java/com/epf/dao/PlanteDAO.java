package com.epf.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epf.model.Plante;

@Repository
public class PlanteDAO {

    private final JdbcTemplate jdbcTemplate;

    public PlanteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Plante> findAll() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Plante plante = new Plante();
            plante.setId(rs.getInt("id_plante"));
            plante.setNom(rs.getString("nom"));
            plante.setPoint_de_vie(rs.getInt("point_de_vie"));
            plante.setDegat_attaque(rs.getInt("degat_attaque"));
            plante.setCout(rs.getInt("cout_soleil"));
            plante.setChemin_image(rs.getString("chemin_image"));
            return plante;
        });
    }

    public Plante findById(int id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Plante plante = new Plante();
            plante.setId(rs.getInt("id_plante"));
            plante.setNom(rs.getString("nom"));
            plante.setPoint_de_vie(rs.getInt("point_de_vie"));
            plante.setDegat_attaque(rs.getInt("degat_attaque"));
            plante.setCout(rs.getInt("cout_soleil"));
            plante.setChemin_image(rs.getString("chemin_image"));
            return plante;
        }, id);
    }

    public void create(Plante plante) {
        String sql = "INSERT INTO plante (nom, point_de_vie, degat_attaque, cout_soleil, chemin_image) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
            plante.getNom(),
            plante.getPoint_de_vie(),
            plante.getDegat_attaque(),
            plante.getCout(),
            plante.getChemin_image()
        );
    }

    public void update(Plante plante) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, degat_attaque = ?, cout_soleil = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql,
            plante.getNom(),
            plante.getPoint_de_vie(),
            plante.getDegat_attaque(),
            plante.getCout(),
            plante.getChemin_image(),
            plante.getId()
        );
    }

    public void delete(int id) {
        String sql = "DELETE FROM plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }
}
