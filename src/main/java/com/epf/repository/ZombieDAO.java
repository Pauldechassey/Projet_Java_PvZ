package com.epf.repository;

import java.util.List;

import com.epf.model.Zombie;

public interface ZombieDAO {
    List<Zombie> findAll();
    Zombie findById(int id);
    void create(Zombie zombie);
    void update(Zombie zombie);
    void delete(int id);
    List<Zombie> findByMapId(int mapId); 
}
