package com.epf.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class MapRepository {
    private final JdbcTemplate jdbcTemplate;

    public MapRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createMap(int ligne, int colonne, String chemin_image) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, ligne, colonne, chemin_image);
    }
    
    public List<Map<String, Object>> findAllMaps() {
        String sql = "SELECT * FROM Map";
        return jdbcTemplate.queryForList(sql);
    }

    public Map<String, Object> findMapById(int id) {
        String sql = "SELECT * FROM Map WHERE id = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

}
