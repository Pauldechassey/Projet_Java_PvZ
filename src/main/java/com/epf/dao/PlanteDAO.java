package com.epf.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epf.exception.DaoException;
import com.epf.model.Plante;

@Repository
public class PlanteDAO {

    private final JdbcTemplate jdbcTemplate;

    public PlanteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Plante> findAll() {
        try {
            String sql = "SELECT * FROM plante";
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Plante plante = new Plante();
                plante.setId(rs.getInt("id_plante"));
                plante.setNom(rs.getString("nom"));
                plante.setPoint_de_vie(rs.getInt("point_de_vie"));
                plante.setDegat_attaque(rs.getInt("degat_attaque"));
                plante.setCout(rs.getInt("cout"));
                plante.setChemin_image(rs.getString("chemin_image"));
                return plante;
            });
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la récupération de toutes les plantes", e);
        }
    }

    public Plante findById(int id) {
        try {
            String sql = "SELECT * FROM plante WHERE id_plante = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Plante plante = new Plante();
                plante.setId(rs.getInt("id_plante"));
                plante.setNom(rs.getString("nom"));
                plante.setPoint_de_vie(rs.getInt("point_de_vie"));
                plante.setDegat_attaque(rs.getInt("degat_attaque"));
                plante.setCout(rs.getInt("cout"));
                plante.setChemin_image(rs.getString("chemin_image"));
                return plante;
            }, id);
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la récupération de la plante avec l'ID: " + id, e);
        }
    }

    public void create(Plante plante) {
        try {
            String sql = "INSERT INTO plante (nom, point_de_vie, degat_attaque, cout, chemin_image) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql,
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getChemin_image()
            );
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la création de la plante", e);
        }
    }

    public void update(Plante plante) {
        try {
            String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, degat_attaque = ?, cout = ?, chemin_image = ? WHERE id_plante = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getChemin_image(),
                plante.getId()
            );
            if (rowsAffected == 0) {
                throw new DaoException("Aucune plante trouvée avec l'ID: " + plante.getId());
            }
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la mise à jour de la plante avec l'ID: " + plante.getId(), e);
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM plante WHERE id_plante = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            if (rowsAffected == 0) {
                throw new DaoException("Aucune plante trouvée avec l'ID: " + id);
            }
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la suppression de la plante avec l'ID: " + id, e);
        }
    }
}
