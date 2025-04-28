package com.epf.Testdao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epf.dao.ZombieDAO;
import com.epf.model.Zombie;

@ExtendWith(MockitoExtension.class)
public class TestZombieDAO {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ZombieDAO zombieDAO;

    private Zombie testZombie;

    @BeforeEach
    void setUp() {
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
    public void testFindAll() {
        @SuppressWarnings("unchecked")
        RowMapper<Zombie> zombieRowMapper = (RowMapper<Zombie>) mock(RowMapper.class);
        when(jdbcTemplate.query(anyString(), eq(zombieRowMapper)))
            .thenReturn(Arrays.asList(testZombie));

        List<Zombie> result = zombieDAO.findAll();
        
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(testZombie.getId_zombie(), result.get(0).getId_zombie());
    }

    @Test
    public void testFindById() {
        @SuppressWarnings("unchecked")
        RowMapper<Zombie> zombieRowMapper = (RowMapper<Zombie>) mock(RowMapper.class);
        when(jdbcTemplate.queryForObject(anyString(), eq(zombieRowMapper), eq(1)))
            .thenReturn(testZombie);

        Zombie result = zombieDAO.findById(1);
        
        assertNotNull(result);
        assertEquals(testZombie.getId_zombie(), result.getId_zombie());
    }

    @Test
    public void testCreate() {
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
    public void testUpdate() {
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
    public void testDelete() {
        zombieDAO.delete(1);

        verify(jdbcTemplate).update(anyString(), eq(1));
    }
}
