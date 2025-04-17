package com.epf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.dao.ZombieDAO;
import com.epf.model.Zombie;

@Service
public class ZombieService {

    private final ZombieDAO zombieDAO;

    public ZombieService(ZombieDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    public List<Zombie> findAll() {
        return zombieDAO.findAll();
    }

    public Zombie findById(int id) {
        return zombieDAO.findById(id);
    }

    public void create(Zombie zombie) {
        zombieDAO.create(zombie);
    }

    public void update(Zombie zombie) {
        zombieDAO.update(zombie);
    }

    public void delete(int id) {
        zombieDAO.delete(id);
    }

    public List<Zombie> findByMapId(int mapId) {
        return zombieDAO.findByMapId(mapId);
    }
}
