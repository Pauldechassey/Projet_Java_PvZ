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

import com.epf.dao.PlanteDAO;
import com.epf.model.Plante;

@ExtendWith(MockitoExtension.class)
public class TestPlanteDAO {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PlanteDAO planteDAO;

    private Plante testPlante;

    @BeforeEach
    public void setUp() {
        testPlante = new Plante();
        testPlante.setId(1);
        testPlante.setNom("Test Plante");
        testPlante.setPoint_de_vie(100);
        testPlante.setDegat_attaque(20);
        testPlante.setCout(50);
        testPlante.setChemin_image("test.png");
    }

    @Test
    public void testFindAll() {
        when(jdbcTemplate.query(
            eq("SELECT * FROM plante"), 
            any(RowMapper.class)))
        .thenReturn(Arrays.asList(testPlante));

        List<Plante> result = planteDAO.findAll();
        
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(testPlante.getId(), result.get(0).getId());
        assertEquals(testPlante.getNom(), result.get(0).getNom());
    }

    @Test
    public void testFindById() {
        when(jdbcTemplate.queryForObject(
            eq("SELECT * FROM plante WHERE id_plante = ?"),
            any(RowMapper.class),
            eq(1)))
        .thenReturn(testPlante);

        Plante result = planteDAO.findById(1);
        
        assertNotNull(result);
        assertEquals(testPlante.getId(), result.getId());
        assertEquals(testPlante.getNom(), result.getNom());
    }

    @Test
    public void testCreate() {
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any(), any()))
            .thenReturn(1);

        planteDAO.create(testPlante);

        verify(jdbcTemplate).update(anyString(), 
            eq(testPlante.getNom()),
            eq(testPlante.getPoint_de_vie()),
            eq(testPlante.getDegat_attaque()),
            eq(testPlante.getCout()),
            eq(testPlante.getChemin_image()));
    }

    @Test
    public void testUpdate() {
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any(), any(), any()))
            .thenReturn(1);

        planteDAO.update(testPlante);

        verify(jdbcTemplate).update(anyString(),
            eq(testPlante.getNom()),
            eq(testPlante.getPoint_de_vie()),
            eq(testPlante.getDegat_attaque()),
            eq(testPlante.getCout()),
            eq(testPlante.getChemin_image()),
            eq(testPlante.getId()));
    }

    @Test
    public void testDelete() {
        when(jdbcTemplate.update(anyString(), eq(1)))
            .thenReturn(1);

        planteDAO.delete(1);

        verify(jdbcTemplate).update(anyString(), eq(1));
    }
}
