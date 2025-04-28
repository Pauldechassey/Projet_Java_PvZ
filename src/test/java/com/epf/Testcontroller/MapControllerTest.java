package com.epf.Testcontroller;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.epf.controller.MapController;
import com.epf.dto.MapDTO;
import com.epf.model.Map;
import com.epf.service.MapService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MapControllerTest {

    @Mock
    private MapService mapService;

    @InjectMocks
    private MapController mapController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private Map testMap;
    private MapDTO testMapDTO;

    @BeforeEach
    @SuppressWarnings("unused")
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mapController).build();
        objectMapper = new ObjectMapper();
        
        testMap = new Map();
        testMap.setId_map(1);
        testMap.setLigne(5);
        testMap.setColonne(8);
        testMap.setChemin_image("test.png");

        testMapDTO = new MapDTO();
        testMapDTO.setId_map(1);
        testMapDTO.setLigne(5);
        testMapDTO.setColonne(8);
        testMapDTO.setChemin_image("test.png");
    }

    @Test
    public void testGetAllMaps() throws Exception {
        when(mapService.findAll()).thenReturn(Arrays.asList(testMap));

        mockMvc.perform(get("/maps")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id_map").value(1))
                .andExpect(jsonPath("$[0].ligne").value(5));
    }

    @Test
    public void testCreateMap() throws Exception {
        mockMvc.perform(post("/maps")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testMapDTO)))
                .andExpect(status().isOk());

        verify(mapService).create(any());
    }
}