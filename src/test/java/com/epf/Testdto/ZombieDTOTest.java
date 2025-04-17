package com.epf.Testdto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.epf.dto.ZombieDTO;
import com.epf.model.Zombie;

class ZombieDTOTest {

    @Test
    void testDTOFromEntity() {
        Zombie zombie = new Zombie();
        zombie.setId_zombie(1);
        zombie.setNom("Basic Zombie");
        zombie.setPoint_de_vie(100);
        zombie.setAttaque_par_seconde(1.0f);
        zombie.setDegat_attaque(20);
        zombie.setVitesse_de_deplacement(1.0f);
        zombie.setChemin_image("zombie.png");
        zombie.setId_map(1);

        ZombieDTO dto = new ZombieDTO(zombie);

        assertEquals(1, dto.getId_zombie());
        assertEquals("Basic Zombie", dto.getNom());
        assertEquals(100, dto.getPoint_de_vie());
        assertEquals(1.0f, dto.getAttaque_par_seconde());
        assertEquals(20, dto.getDegat_attaque());
        assertEquals(1.0f, dto.getVitesse_de_deplacement());
        assertEquals("zombie.png", dto.getChemin_image());
        assertEquals(1, dto.getId_map());
    }

    @Test
    void testEntityFromDTO() {
        ZombieDTO dto = new ZombieDTO();
        dto.setId_zombie(1);
        dto.setNom("Basic Zombie");
        dto.setPoint_de_vie(100);
        dto.setAttaque_par_seconde(1.0f);
        dto.setDegat_attaque(20);
        dto.setVitesse_de_deplacement(1.0f);
        dto.setChemin_image("zombie.png");
        dto.setId_map(1);

        Zombie zombie = dto.toEntity();

        assertEquals(1, zombie.getId_zombie());
        assertEquals("Basic Zombie", zombie.getNom());
        assertEquals(100, zombie.getPoint_de_vie());
        assertEquals(1.0f, zombie.getAttaque_par_seconde());
        assertEquals(20, zombie.getDegat_attaque());
        assertEquals(1.0f, zombie.getVitesse_de_deplacement());
        assertEquals("zombie.png", zombie.getChemin_image());
        assertEquals(1, zombie.getId_map());
    }
}