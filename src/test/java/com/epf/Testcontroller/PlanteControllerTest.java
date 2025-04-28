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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.epf.controller.PlanteController;
import com.epf.dto.PlanteDTO;
import com.epf.model.Plante;
import com.epf.service.PlanteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class PlanteControllerTest {

    @Mock
    private PlanteService planteService;

    @InjectMocks
    private PlanteController planteController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private Plante testPlante;
    private PlanteDTO testPlanteDTO;

    @BeforeEach
    @SuppressWarnings("unused")
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(planteController).build();
        objectMapper = new ObjectMapper();
        
        testPlante = new Plante();
        testPlante.setId(1);
        testPlante.setNom("Test Plante");
        testPlante.setPoint_de_vie(100);
        testPlante.setDegat_attaque(20);
        testPlante.setCout(50);
        testPlante.setChemin_image("plante.png");

        testPlanteDTO = new PlanteDTO();
        testPlanteDTO.setId(1);
        testPlanteDTO.setNom("Test Plante");
        testPlanteDTO.setPoint_de_vie(100);
        testPlanteDTO.setDegat_attaque(20);
        testPlanteDTO.setCout(50);
        testPlanteDTO.setChemin_image("plante.png");
    }

    @Test
    public void testGetAllPlantes() throws Exception {
        when(planteService.findAll()).thenReturn(Arrays.asList(testPlante));

        mockMvc.perform(get("/plantes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nom").value("Test Plante"));
    }

    @Test
    public void testGetPlanteById() throws Exception {
        when(planteService.findById(1)).thenReturn(testPlante);

        mockMvc.perform(get("/plantes/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testCreatePlante() throws Exception {
        mockMvc.perform(post("/plantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testPlanteDTO)))
                .andExpect(status().isOk());

        verify(planteService).create(any());
    }

    @Test
    public void testUpdatePlante() throws Exception {
        mockMvc.perform(put("/plantes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testPlanteDTO)))
                .andExpect(status().isOk());

        verify(planteService).update(any());
    }

    @Test
    public void testDeletePlante() throws Exception {
        mockMvc.perform(delete("/plantes/1"))
                .andExpect(status().isOk());

        verify(planteService).delete(1);
    }
}