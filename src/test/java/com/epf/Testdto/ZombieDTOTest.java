package com.epf.Testdto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.epf.dto.ZombieDTO;
import com.epf.model.Zombie;

public class ZombieDTOTest {

    @Test
    public void testDTOFromEntity() {
        Zombie zombie = new Zombie();
        zombie.setId_zombie(1);
        zombie.setNom("Basic Zombie");
        zombie.setPoint_de_vie(100);
        zombie.setAttaque_par_seconde(1);
        zombie.setDegat_attaque(20);
        zombie.setVitesse_de_deplacement(1);
        zombie.setChemin_image("zombie.png");
        zombie.setId_map(1);

        ZombieDTO dto = new ZombieDTO(zombie);

        assertEquals(1, dto.getId_zombie());
        assertEquals("Basic Zombie", dto.getNom());
        assertEquals(100, dto.getPoint_de_vie());
        assertEquals(1, dto.getAttaque_par_seconde(), 0.001);
        assertEquals(20, dto.getDegat_attaque());
        assertEquals(1, dto.getVitesse_de_deplacement(), 0.001);
        assertEquals("zombie.png", dto.getChemin_image());
        assertEquals(1, dto.getId_map());
    }

    @Test
    public void testEntityFromDTO() {
        ZombieDTO dto = new ZombieDTO();
        dto.setId_zombie(1);
        dto.setNom("Basic Zombie");
        dto.setPoint_de_vie(100);
        dto.setAttaque_par_seconde(1);
        dto.setDegat_attaque(20);
        dto.setVitesse_de_deplacement(1);
        dto.setChemin_image("zombie.png");
        dto.setId_map(1);

        Zombie zombie = dto.toEntity();

        assertEquals(1, zombie.getId_zombie());
        assertEquals("Basic Zombie", zombie.getNom());
        assertEquals(100, zombie.getPoint_de_vie());
        assertEquals(1, zombie.getAttaque_par_seconde(), 0.001);
        assertEquals(20, zombie.getDegat_attaque());
        assertEquals(1, zombie.getVitesse_de_deplacement(),0.001);
        assertEquals("zombie.png", zombie.getChemin_image());
        assertEquals(1, zombie.getId_map());
    }
}