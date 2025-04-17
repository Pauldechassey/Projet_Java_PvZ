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

import com.epf.controller.ZombieController;
import com.epf.dto.ZombieDTO;
import com.epf.model.Zombie;
import com.epf.service.ZombieService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ZombieController.class)
class ZombieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ZombieService zombieService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllZombies() throws Exception {
        Zombie zombie = new Zombie();
        zombie.setId_zombie(1);
        zombie.setNom("Basic Zombie");

        when(zombieService.findAll()).thenReturn(Arrays.asList(zombie));

        mockMvc.perform(get("/zombies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id_zombie").value(1))
                .andExpect(jsonPath("$[0].nom").value("Basic Zombie"));
    }

    @Test
    void testCreateZombie() throws Exception {
        ZombieDTO zombieDTO = new ZombieDTO();
        zombieDTO.setNom("Basic Zombie");
        zombieDTO.setPoint_de_vie(100);
        zombieDTO.setId_map(1);

        mockMvc.perform(post("/zombies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(zombieDTO)))
                .andExpect(status().isOk());

        verify(zombieService).create(any(Zombie.class));
    }
}