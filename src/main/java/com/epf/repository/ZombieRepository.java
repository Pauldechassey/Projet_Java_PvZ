package com.epf.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epf.model.Zombie;

@Repository
public class ZombieRepository {

    private final JdbcTemplate jdbcTemplate;

    public ZombieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zombie> findAll() {
        return jdbcTemplate.query("SELECT * FROM Zombie", new BeanPropertyRowMapper<>(Zombie.class));
    }

    public Zombie findById(int idZombie) {
        String sql = "SELECT * FROM Zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Zombie.class), idZombie);
    }

    public void create(Zombie zombie) {
        String sql = "INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(),
                            zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image(), zombie.getId_map());
    }

    public void update(Zombie zombie) {
        String sql = "UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(),
                            zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image(), zombie.getId_map(), zombie.getId_zombie());
    }

    public void delete(int idZombie) {
        String sql = "DELETE FROM Zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, idZombie);
    }

    public List<Zombie> findByMapId(int mapId) {
        String sql = "SELECT * FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Zombie.class), mapId);
    }
}
