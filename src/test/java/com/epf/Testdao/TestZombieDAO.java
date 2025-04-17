package com.epf.Testdao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.epf.config.TestConfig;
import com.epf.dao.ZombieDAO;
import com.epf.model.Zombie;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class TestZombieDAO {
    
    @Autowired
    private ZombieDAO zombieDAO;

    @Test
    public void testFindAll() {
        List<Zombie> zombies = zombieDAO.findAll();
        assertNotNull(zombies);
    }

    @Test
    public void testFindById() {
        Zombie zombie = zombieDAO.findById(1);
        assertNotNull(zombie);
    }

    @Test
    public void testCreate() {
        Zombie zombie = new Zombie();
        zombie.setNom("Test");
        zombie.setPoint_de_vie(100);
        zombie.setAttaque_par_seconde(1.0f);
        zombie.setDegat_attaque(10);
        zombie.setVitesse_de_deplacement(1.0f);
        zombie.setChemin_image("test.png");
        zombie.setId_map(1);

        zombieDAO.create(zombie);
    }

    @Test
    public void testUpdate() {
        Zombie zombie = zombieDAO.findById(1);
        zombie.setNom("Updated");
        zombieDAO.update(zombie);
    }

    @Test
    public void testDelete() {
        zombieDAO.delete(1);
    }

    @Test
    public void testFindByMapId() {
        List<Zombie> zombies = zombieDAO.findByMapId(1);
        assertNotNull(zombies);
    }
}
