package com.epf.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epf.exception.DaoException;
import com.epf.model.Map;

@Repository
public class MapDAO {

    private final JdbcTemplate jdbcTemplate;

    public MapDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map> findAll() {
        try {
            String sql = "SELECT * FROM map";
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Map map = new Map();
                map.setId_map(rs.getInt("id_map"));
                map.setLigne(rs.getInt("ligne"));
                map.setColonne(rs.getInt("colonne"));
                map.setChemin_image(rs.getString("chemin_image"));
                return map;
            });
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la récupération de toutes les maps", e);
        }
    }

    public Map findById(int id) {
        try {
            String sql = "SELECT * FROM map WHERE id_map = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Map map = new Map();
                map.setId_map(rs.getInt("id_map"));
                map.setLigne(rs.getInt("ligne"));
                map.setColonne(rs.getInt("colonne"));
                map.setChemin_image(rs.getString("chemin_image"));
                return map;
            }, id);
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la récupération de la map avec l'ID: " + id, e);
        }
    }

    public void create(Map map) {
        try {
            String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql,
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image()
            );
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la création de la map", e);
        }
    }

    public void update(Map map) {
        try {
            String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image(),
                map.getId_map()
            );
            if (rowsAffected == 0) {
                throw new DaoException("Aucune map trouvée avec l'ID: " + map.getId_map());
            }
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la mise à jour de la map avec l'ID: " + map.getId_map(), e);
        }
    }

    public void delete(int id) {
        try {
            String deleteZombiesSQL = "DELETE FROM zombie WHERE id_map = ?";
            jdbcTemplate.update(deleteZombiesSQL, id);

            String deleteMapSQL = "DELETE FROM map WHERE id_map = ?";
            int rowsAffected = jdbcTemplate.update(deleteMapSQL, id);
            
            if (rowsAffected == 0) {
                throw new DaoException("Aucune map trouvée avec l'ID: " + id);
            }
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la suppression de la map avec l'ID: " + id, e);
        }
    }
}
