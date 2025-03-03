package com.epf.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PlanteRepository {

    private final JdbcTemplate jdbcTemplate;

    public PlanteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findAllPlante() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> findPlanteById(int id) {
        String sql = "SELECT * FROM plante WHERE id = ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    public void createPlante(String nom, String description, String image) {
        String sql = "INSERT INTO plante (nom, description, image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, nom, description, image);
    }

    public void updatePlante(int id, String nom, String description, String image) {
        String sql = "UPDATE plante SET nom = ?, description = ?, image = ? WHERE id = ?";
        jdbcTemplate.update(sql, nom, description, image, id);
    }
}
