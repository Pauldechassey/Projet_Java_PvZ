package com.epf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.dto.ZombieDTO;
import com.epf.model.Zombie;
import com.epf.service.ZombieService;

@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    @GetMapping
    public List<ZombieDTO> getAllZombies() {
        return zombieService.findAll().stream()
            .map(ZombieDTO::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZombieDTO> getZombieById(@PathVariable("id") int id) { // Ajout explicite du nom "id"
        Zombie zombie = zombieService.findById(id);
        ZombieDTO zombieDTO = new ZombieDTO(zombie);
        return ResponseEntity.ok(zombieDTO);
    }

    @PostMapping
    public void createZombie(@RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = zombieDTO.toEntity();
        zombieService.create(zombie);
    }

    @PutMapping("/{id}")
    public void updateZombie(@PathVariable("id") int id, @RequestBody ZombieDTO zombieDTO) { 
        Zombie zombie = zombieDTO.toEntity();
        zombie.setId_zombie(id);
        zombieService.update(zombie);
    }

    @DeleteMapping("/{id}")
    public void deleteZombie(@PathVariable("id") int id) { 
        zombieService.delete(id);
    }

    @GetMapping("/map/{mapId}")
    public List<ZombieDTO> getZombiesByMap(@PathVariable("mapId") int mapId) {
        return zombieService.findByMapId(mapId).stream()
            .map(ZombieDTO::new)
            .collect(Collectors.toList());
    }
}
