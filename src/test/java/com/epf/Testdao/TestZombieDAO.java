package com.epf.Testdao;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epf.dao.ZombieDAO;
import com.epf.model.Zombie;

@ExtendWith(MockitoExtension.class)
class TestZombieDAO {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ZombieDAO zombieDAO;

    private Zombie testZombie;

    @BeforeEach
    public void setUp() {
        testZombie = new Zombie();
        testZombie.setId_zombie(1);
        testZombie.setNom("Test Zombie");
        testZombie.setPoint_de_vie(100);
        testZombie.setAttaque_par_seconde(1.0f);
        testZombie.setDegat_attaque(20);
        testZombie.setVitesse_de_deplacement(1.0f);
        testZombie.setChemin_image("zombie.png");
        testZombie.setId_map(1);
    }

    @Test
    void testFindAll() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class)))
            .thenReturn(Arrays.asList(testZombie));

        List<Zombie> result = zombieDAO.findAll();
        
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(testZombie.getId_zombie(), result.get(0).getId_zombie());
    }

    @Test
    void testFindById() {
        when(jdbcTemplate.queryForObject(
            eq("SELECT * FROM zombie WHERE id_zombie = ?"), 
            any(RowMapper.class), 
            eq(1)))
        .thenReturn(testZombie);

        Zombie result = zombieDAO.findById(1);
        
        assertNotNull(result);
        assertEquals(testZombie.getId_zombie(), result.getId_zombie());
        assertEquals(testZombie.getNom(), result.getNom());
    }

    @Test
    void testCreate() {
        when(jdbcTemplate.update(
            eq("INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)"),
            eq(testZombie.getNom()),
            eq(testZombie.getPoint_de_vie()),
            eq(testZombie.getAttaque_par_seconde()),
            eq(testZombie.getDegat_attaque()),
            eq(testZombie.getVitesse_de_deplacement()),
            eq(testZombie.getChemin_image()),
            eq(testZombie.getId_map())))
        .thenReturn(1);

        zombieDAO.create(testZombie);

        verify(jdbcTemplate).update(anyString(), 
            eq(testZombie.getNom()),
            eq(testZombie.getPoint_de_vie()),
            eq(testZombie.getAttaque_par_seconde()),
            eq(testZombie.getDegat_attaque()),
            eq(testZombie.getVitesse_de_deplacement()),
            eq(testZombie.getChemin_image()),
            eq(testZombie.getId_map()));
    }

    @Test
    void testUpdate() {
        when(jdbcTemplate.update(anyString(),
            eq(testZombie.getNom()),
            eq(testZombie.getPoint_de_vie()),
            eq(testZombie.getAttaque_par_seconde()),
            eq(testZombie.getDegat_attaque()),
            eq(testZombie.getVitesse_de_deplacement()),
            eq(testZombie.getChemin_image()),
            eq(testZombie.getId_map()),
            eq(testZombie.getId_zombie())))
        .thenReturn(1);

        zombieDAO.update(testZombie);

        verify(jdbcTemplate).update(anyString(),
            eq(testZombie.getNom()),
            eq(testZombie.getPoint_de_vie()),
            eq(testZombie.getAttaque_par_seconde()),
            eq(testZombie.getDegat_attaque()),
            eq(testZombie.getVitesse_de_deplacement()),
            eq(testZombie.getChemin_image()),
            eq(testZombie.getId_map()),
            eq(testZombie.getId_zombie()));
    }

    @Test
    void testDelete() {
        when(jdbcTemplate.update(
            eq("DELETE FROM zombie WHERE id_zombie = ?"), 
            eq(1)))
        .thenReturn(1);

        zombieDAO.delete(1);

        verify(jdbcTemplate).update(anyString(), eq(1));
    }
}
