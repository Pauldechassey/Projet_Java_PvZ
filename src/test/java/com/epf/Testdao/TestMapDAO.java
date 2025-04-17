package com.epf.Testdao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.epf.config.TestConfig;
import com.epf.dao.MapDAO;
import com.epf.model.Map;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
public class TestMapDAO {
    
    @Autowired
    private MapDAO mapDAO;

    @Test
    public void testFindAll() {
        List<Map> maps = mapDAO.findAll();
        assertNotNull(maps);
    }

    @Test
    public void testFindById() {
        Map map = mapDAO.findById(1);
        assertNotNull(map);
    }

    @Test
    public void testCreate() {
        Map map = new Map();
        map.setLigne(10);
        map.setColonne(8);
        map.setChemin_image("test_map.png");

        mapDAO.create(map);
    }

    @Test
    public void testUpdate() {
        Map map = mapDAO.findById(1);
        map.setLigne(12);
        mapDAO.update(map);
    }

    @Test
    public void testDelete() {
        mapDAO.delete(1);
    }

    @Test
    public void testDatabaseConnection() {
        // Simple query to verify connection
        List<Map> maps = mapDAO.findAll();
        System.out.println("Successfully connected to database and found " + maps.size() + " maps");
    }
}
