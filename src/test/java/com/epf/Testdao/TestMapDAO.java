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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epf.dao.MapDAO;
import com.epf.model.Map;

@ExtendWith(MockitoExtension.class)
public class TestMapDAO {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private MapDAO mapDAO;

    private Map testMap;

    @BeforeEach
    public void setUp() {
        testMap = new Map();
        testMap.setId_map(1);
        testMap.setLigne(5);
        testMap.setColonne(8);
        testMap.setChemin_image("test.png");
    }

    @Test
    public void testFindAll() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class)))
            .thenReturn(Arrays.asList(testMap));

        List<Map> result = mapDAO.findAll();
        
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(testMap.getId_map(), result.get(0).getId_map());
    }

    @Test
    public void testFindById() {
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(1)))
            .thenReturn(testMap);

        Map result = mapDAO.findById(1);
        
        assertNotNull(result);
        assertEquals(testMap.getId_map(), result.getId_map());
    }

    @Test
    public void testCreate() {
        when(jdbcTemplate.update(anyString(), any(), any(), any()))
            .thenReturn(1);
        
        mapDAO.create(testMap);

        verify(jdbcTemplate, times(1)).update(anyString(), 
            eq(testMap.getLigne()),
            eq(testMap.getColonne()),
            eq(testMap.getChemin_image()));
    }

    @Test
    public void testUpdate() {
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any()))
            .thenReturn(1);

        mapDAO.update(testMap);

        verify(jdbcTemplate).update(anyString(),
            eq(testMap.getLigne()),
            eq(testMap.getColonne()),
            eq(testMap.getChemin_image()),
            eq(testMap.getId_map()));
    }

    @Test
    public void testDelete() {
        when(jdbcTemplate.update(anyString(), eq(1)))
            .thenReturn(1);
        
        mapDAO.delete(1);

        verify(jdbcTemplate, times(1)).update(anyString(), eq(1));
    }
}
