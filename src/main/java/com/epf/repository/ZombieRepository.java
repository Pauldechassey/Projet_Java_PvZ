package com.epf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epf.model.Zombie;

@Repository
public class ZombieRepository implements ZombieDAO {
    private final JdbcTemplate jdbcTemplate;

    public ZombieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Zombie> findAll() {
        return jdbcTemplate.query("SELECT * FROM Zombie", new BeanPropertyRowMapper<>(Zombie.class));
    }

    @Override
    public Optional<Zombie> findById(int id) {
        return jdbcTemplate.query("SELECT * FROM Zombie WHERE id = ?", new BeanPropertyRowMapper<>(Zombie.class), id)
                .stream().findFirst();
    }

    @Override
    public List<Zombie> findByMapId(int mapId) {
        return jdbcTemplate.query("SELECT * FROM Zombie WHERE id_map = ?", new BeanPropertyRowMapper<>(Zombie.class), mapId);
    }
}
