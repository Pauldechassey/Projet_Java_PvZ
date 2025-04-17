package com.epf.Testdto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.epf.dto.MapDTO;
import com.epf.model.Map;

class MapDTOTest {

    @Test
    void testDTOFromEntity() {
        Map map = new Map();
        map.setId_map(1);
        map.setLigne(5);
        map.setColonne(8);
        map.setChemin_image("map.png");

        MapDTO dto = new MapDTO(map);

        assertEquals(1, dto.getId_map());
        assertEquals(5, dto.getLigne());
        assertEquals(8, dto.getColonne());
        assertEquals("map.png", dto.getChemin_image());
    }

    @Test
    void testEntityFromDTO() {
        MapDTO dto = new MapDTO();
        dto.setId_map(1);
        dto.setLigne(5);
        dto.setColonne(8);
        dto.setChemin_image("map.png");

        Map map = dto.toEntity();

        assertEquals(1, map.getId_map());
        assertEquals(5, map.getLigne());
        assertEquals(8, map.getColonne());
        assertEquals("map.png", map.getChemin_image());
    }
}