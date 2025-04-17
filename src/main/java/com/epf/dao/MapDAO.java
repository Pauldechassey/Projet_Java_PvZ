package com.epf.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epf.model.Map;

@Repository
public class MapDAO {

    private final JdbcTemplate jdbcTemplate;

    public MapDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map> findAll() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Map map = new Map();
            map.setId_map(rs.getInt("id_map"));
            map.setLigne(rs.getInt("ligne"));
            map.setColonne(rs.getInt("colonne"));
            map.setChemin_image(rs.getString("chemin_image"));
            return map;
        });
    }

    public Map findById(int id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Map map = new Map();
            map.setId_map(rs.getInt("id_map"));
            map.setLigne(rs.getInt("ligne"));
            map.setColonne(rs.getInt("colonne"));
            map.setChemin_image(rs.getString("chemin_image"));
            return map;
        }, id);
    }

    public void create(Map map) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
            map.getLigne(),
            map.getColonne(),
            map.getChemin_image()
        );
    }

    public void update(Map map) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql,
            map.getLigne(),
            map.getColonne(),
            map.getChemin_image(),
            map.getId_map()
        );
    }

    public void delete(int id) {
        String sql = "DELETE FROM map WHERE id_map = ?";
        jdbcTemplate.update(sql, id);
    }
}
