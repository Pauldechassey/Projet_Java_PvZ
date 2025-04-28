package com.epf.Testdto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.epf.dto.PlanteDTO;
import com.epf.model.Effet;
import com.epf.model.Plante;

public class PlanteDTOTest {

    @Test
    public  void testDTOFromEntity() {
        Plante plante = new Plante();
        plante.setNom("NORMAL");  // Update test to expect uppercase

        PlanteDTO dto = new PlanteDTO(plante);
        assertEquals("NORMAL", dto.getNom());
    }

    @Test
    public void testEntityFromDTO() {
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