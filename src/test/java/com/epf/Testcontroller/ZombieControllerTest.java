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

import com.epf.controller.ZombieController;
import com.epf.dto.ZombieDTO;
import com.epf.model.Zombie;
import com.epf.service.ZombieService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class ZombieControllerTest {

    @Mock
    private ZombieService zombieService;

    @InjectMocks
    private ZombieController zombieController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private Zombie testZombie;
    private ZombieDTO testZombieDTO;

    @BeforeEach
    @SuppressWarnings("unused")
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(zombieController).build();
        objectMapper = new ObjectMapper();
        
        testZombie = new Zombie();
        testZombie.setId_zombie(1);
        testZombie.setNom("Test Zombie");
        testZombie.setPoint_de_vie(100);
        testZombie.setAttaque_par_seconde(1.0f);
        testZombie.setDegat_attaque(20);
        testZombie.setVitesse_de_deplacement(1.0f);
        testZombie.setChemin_image("zombie.png");
        testZombie.setId_map(1);

        testZombieDTO = new ZombieDTO();
        testZombieDTO.setId_zombie(1);
        testZombieDTO.setNom("Test Zombie");
        testZombieDTO.setPoint_de_vie(100);
        testZombieDTO.setAttaque_par_seconde(1.0f);
        testZombieDTO.setDegat_attaque(20);
        testZombieDTO.setVitesse_de_deplacement(1.0f);
        testZombieDTO.setChemin_image("zombie.png");
        testZombieDTO.setId_map(1);
    }

    @Test
    public void testGetAllZombies() throws Exception {
        when(zombieService.findAll()).thenReturn(Arrays.asList(testZombie));

        mockMvc.perform(get("/zombies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id_zombie").value(1))
                .andExpect(jsonPath("$[0].nom").value("Test Zombie"));
    }

    @Test
    public void testGetZombieById() throws Exception {
        when(zombieService.findById(1)).thenReturn(testZombie);

        mockMvc.perform(get("/zombies/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_zombie").value(1));
    }

    @Test
    public void testGetZombiesByMapId() throws Exception {
        when(zombieService.findByMapId(1)).thenReturn(Arrays.asList(testZombie));

        mockMvc.perform(get("/zombies/map/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id_zombie").value(1));
    }

    @Test
    public void testCreateZombie() throws Exception {
        mockMvc.perform(post("/zombies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testZombieDTO)))
                .andExpect(status().isOk());

        verify(zombieService).create(any());
    }

    @Test
    public void testUpdateZombie() throws Exception {
        mockMvc.perform(put("/zombies/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testZombieDTO)))
                .andExpect(status().isOk());

        verify(zombieService).update(any());
    }

    @Test
    public void testDeleteZombie() throws Exception {
        mockMvc.perform(delete("/zombies/1"))
                .andExpect(status().isOk());

        verify(zombieService).delete(1);
    }
}