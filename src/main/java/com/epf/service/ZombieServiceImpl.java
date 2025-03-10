package com.epf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.model.Zombie;
import com.epf.repository.ZombieRepository;

@Service
public class ZombieServiceImpl implements ZombieService {

    private final ZombieRepository zombieRepository;

    public ZombieServiceImpl(ZombieRepository zombieRepository) {
        this.zombieRepository = zombieRepository;
    }

    @Override
    public List<Zombie> findAll() {
        return zombieRepository.findAll();
    }

    @Override
    public Zombie findById(int id) {
        return zombieRepository.findById(id);
    }

    @Override
    public void create(Zombie zombie) {
        zombieRepository.create(zombie);
    }

    @Override
    public void update(Zombie zombie) {
        zombieRepository.update(zombie);
    }

    @Override
    public void delete(int id) {
        zombieRepository.delete(id);
    }

    @Override
    public List<Zombie> findByMapId(int mapId) {
        return zombieRepository.findByMapId(mapId);
    }
}
