package com.epf.service;

import com.epf.model.Zombie;
import java.util.List;

public interface ZombieService {
    List<Zombie> findAll();
    Zombie findById(int id);
    void create(Zombie zombie);
    void update(Zombie zombie);
    void delete(int id);
    List<Zombie> findByMapId(int mapId);
}
