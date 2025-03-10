package com.epf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.model.Zombie;
import com.epf.service.ZombieService;

@RestController
@RequestMapping("/zombie")
public class ZombieController {

    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    @GetMapping
    public List<Zombie> getAllZombies() {
        return zombieService.findAll();
    }

    @GetMapping("/{id}")
    public Zombie getZombieById(@PathVariable int id) {
        return zombieService.findById(id);
    }

    @PostMapping
    public void createZombie(@RequestBody Zombie zombie) {
        zombieService.create(zombie);
    }

    @PutMapping("/{id}")
    public void updateZombie(@PathVariable int id, @RequestBody Zombie zombie) {
        zombie.setId_zombie(id); // On s'assure que l'ID est bien celui du path
        zombieService.update(zombie);
    }

    @DeleteMapping("/{id}")
    public void deleteZombie(@PathVariable int id) {
        zombieService.delete(id);
    }

    @GetMapping("/map/{mapId}")
    public List<Zombie> getZombiesByMap(@PathVariable int mapId) {
        return zombieService.findByMapId(mapId);
    }
}
