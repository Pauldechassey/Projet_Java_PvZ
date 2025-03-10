package com.epf.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epf.model.Map;

@Repository
public class MapRepository implements MapDAO {

    private final JdbcTemplate jdbcTemplate;

    public MapRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map> findAll() {
        return jdbcTemplate.query("SELECT * FROM Map", new BeanPropertyRowMapper<>(Map.class));
    }

    @Override
    public Map findById(int id) {
        String sql = "SELECT * FROM Map WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Map.class), id);
    }

    @Override
    public void create(Map map) {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    @Override
    public void update(Map map) {
        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image(), map.getId_map());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Map WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
