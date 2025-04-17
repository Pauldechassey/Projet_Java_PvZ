package com.epf.Testdao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.epf.config.TestConfig;
import com.epf.dao.PlanteDAO;
import com.epf.model.Plante;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class TestPlanteDAO {
    
    @Autowired
    private PlanteDAO planteDAO;

    @Test
    public void testFindAll() {
        List<Plante> plantes = planteDAO.findAll();
        assertNotNull(plantes);
    }

    @Test
    public void testFindById() {
        Plante plante = planteDAO.findById(1);
        assertNotNull(plante);
    }

    @Test
    public void testCreate() {
        Plante plante = new Plante();
        plante.setNom("Test Plante");
        plante.setPoint_de_vie(100);
        plante.setDegat_attaque(20);
        plante.setCout(50);
        plante.setChemin_image("test.png");

        planteDAO.create(plante);
    }

    @Test
    public void testUpdate() {
        Plante plante = planteDAO.findById(1);
        plante.setNom("Updated Plante");
        planteDAO.update(plante);
    }

    @Test
    public void testDelete() {
        planteDAO.delete(1);
    }
}
