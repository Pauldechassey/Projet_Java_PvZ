package com.epf.Testdto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.epf.dto.PlanteDTO;
import com.epf.model.Effet;
import com.epf.model.Plante;

class PlanteDTOTest {

    @Test
    void testDTOFromEntity() {
        Plante plante = new Plante();
        plante.setId(1);
        plante.setNom("Peashooter");
        plante.setPoint_de_vie(100);
        plante.setDegat_attaque(20);
        plante.setCout(100);
        plante.setChemin_image("peashooter.png");
        plante.setEffet(Effet.NORMAL);

        PlanteDTO dto = new PlanteDTO(plante);

        assertEquals(1, dto.getId());
        assertEquals("Peashooter", dto.getNom());
        assertEquals(100, dto.getPoint_de_vie());
        assertEquals(20, dto.getDegat_attaque());
        assertEquals(100, dto.getCout());
        assertEquals("peashooter.png", dto.getChemin_image());
        assertEquals("normal", dto.getEffet());
    }

    @Test
    void testEntityFromDTO() {
        PlanteDTO dto = new PlanteDTO();
        dto.setId(1);
        dto.setNom("Peashooter");
        dto.setPoint_de_vie(100);
        dto.setDegat_attaque(20);
        dto.setCout(100);
        dto.setChemin_image("peashooter.png");
        dto.setEffet(Effet.NORMAL);

        Plante plante = dto.toEntity();

        assertEquals(1, plante.getId());
        assertEquals("Peashooter", plante.getNom());
        assertEquals(100, plante.getPoint_de_vie());
        assertEquals(20, plante.getDegat_attaque());
        assertEquals(100, plante.getCout());
        assertEquals("peashooter.png", plante.getChemin_image());
        assertEquals(Effet.NORMAL, plante.getEffet());
    }
}