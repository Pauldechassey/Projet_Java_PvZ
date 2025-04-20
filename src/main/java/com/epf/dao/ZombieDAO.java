package com.epf.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epf.exception.DaoException;
import com.epf.model.Zombie;

@Repository
public class ZombieDAO {

    private final JdbcTemplate jdbcTemplate;

    public ZombieDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zombie> findAll() {
        try {
            String sql = "SELECT * FROM zombie";
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Zombie zombie = new Zombie();
                zombie.setId_zombie(rs.getInt("id_zombie"));
                zombie.setNom(rs.getString("nom"));
                zombie.setPoint_de_vie(rs.getInt("point_de_vie"));
                zombie.setAttaque_par_seconde(rs.getFloat("attaque_par_seconde"));
                zombie.setDegat_attaque(rs.getInt("degat_attaque"));
                zombie.setVitesse_de_deplacement(rs.getFloat("vitesse_de_deplacement"));
                zombie.setChemin_image(rs.getString("chemin_image"));
                zombie.setId_map(rs.getInt("id_map"));
                return zombie;
            });
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la récupération de tous les zombies", e);
        }
    }

    public Zombie findById(int id) {
        try {
            String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Zombie zombie = new Zombie();
                zombie.setId_zombie(rs.getInt("id_zombie"));
                zombie.setNom(rs.getString("nom"));
                zombie.setPoint_de_vie(rs.getInt("point_de_vie"));
                zombie.setAttaque_par_seconde(rs.getFloat("attaque_par_seconde"));
                zombie.setDegat_attaque(rs.getInt("degat_attaque"));
                zombie.setVitesse_de_deplacement(rs.getFloat("vitesse_de_deplacement"));
                zombie.setChemin_image(rs.getString("chemin_image"));
                zombie.setId_map(rs.getInt("id_map"));
                return zombie;
            }, id);
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la récupération du zombie avec l'ID: " + id, e);
        }
    }

    public void create(Zombie zombie) {
        try {
            String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql,
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map()
            );
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la création du zombie", e);
        }
    }

    public void update(Zombie zombie) {
        try {
            String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
            int rowsAffected = jdbcTemplate.update(sql,
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map(),
                zombie.getId_zombie()
            );
            if (rowsAffected == 0) {
                throw new DaoException("Aucun zombie trouvé avec l'ID: " + zombie.getId_zombie());
            }
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la mise à jour du zombie avec l'ID: " + zombie.getId_zombie(), e);
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM zombie WHERE id_zombie = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);
            if (rowsAffected == 0) {
                throw new DaoException("Aucun zombie trouvé avec l'ID: " + id);
            }
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la suppression du zombie avec l'ID: " + id, e);
        }
    }

    public List<Zombie> findByMapId(int mapId) {
        try {
            String sql = "SELECT * FROM zombie WHERE id_map = ?";
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Zombie zombie = new Zombie();
                zombie.setId_zombie(rs.getInt("id_zombie"));
                zombie.setNom(rs.getString("nom"));
                zombie.setPoint_de_vie(rs.getInt("point_de_vie"));
                zombie.setAttaque_par_seconde(rs.getFloat("attaque_par_seconde"));
                zombie.setDegat_attaque(rs.getInt("degat_attaque"));
                zombie.setVitesse_de_deplacement(rs.getFloat("vitesse_de_deplacement"));
                zombie.setChemin_image(rs.getString("chemin_image"));
                zombie.setId_map(rs.getInt("id_map"));
                return zombie;
            }, mapId);
        } catch (DataAccessException e) {
            throw new DaoException("Erreur lors de la récupération des zombies pour la map ID: " + mapId, e);
        }
    }
}
