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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.epf.controller.PlanteController;
import com.epf.dto.PlanteDTO;
import com.epf.model.Plante;
import com.epf.service.PlanteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PlanteController.class)
class PlanteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanteService planteService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllPlantes() throws Exception {
        Plante plante = new Plante();
        plante.setId(1);
        plante.setNom("Peashooter");

        when(planteService.findAll()).thenReturn(Arrays.asList(plante));

        mockMvc.perform(get("/plantes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id_plante").value(1))
                .andExpect(jsonPath("$[0].nom").value("Peashooter"));
    }

    @Test
    void testCreatePlante() throws Exception {
        PlanteDTO planteDTO = new PlanteDTO();
        planteDTO.setNom("Peashooter");
        planteDTO.setPoint_de_vie(100);

        mockMvc.perform(post("/plantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(planteDTO)))
                .andExpect(status().isOk());

        verify(planteService).create(any(Plante.class));
    }
}