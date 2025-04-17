package com.epf.Testcontroller;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.epf.controller.MapController;
import com.epf.dto.MapDTO;
import com.epf.model.Map;
import com.epf.service.MapService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MapController.class)
class MapControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MapService mapService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllMaps() throws Exception {
        Map map = new Map();
        map.setId_map(1);
        map.setLigne(5);
        map.setColonne(8);

        when(mapService.findAll()).thenReturn(Arrays.asList(map));

        mockMvc.perform(get("/maps")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id_map").value(1))
                .andExpect(jsonPath("$[0].ligne").value(5))
                .andExpect(jsonPath("$[0].colonne").value(8));
    }

    @Test
    void testCreateMap() throws Exception {
        MapDTO mapDTO = new MapDTO();
        mapDTO.setLigne(5);
        mapDTO.setColonne(8);
        mapDTO.setChemin_image("map.png");

        mockMvc.perform(post("/maps")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mapDTO)))
                .andExpect(status().isOk());

        verify(mapService).create(any(Map.class));
    }

    @Test
    void testUpdateMap() throws Exception {
        MapDTO mapDTO = new MapDTO();
        mapDTO.setLigne(6);
        mapDTO.setColonne(9);

        mockMvc.perform(put("/maps/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mapDTO)))
                .andExpect(status().isOk());

        verify(mapService).update(any(Map.class));
    }

    @Test
    void testDeleteMap() throws Exception {
        mockMvc.perform(delete("/maps/1"))
                .andExpect(status().isOk());

        verify(mapService).delete(1);
    }
}