package com.epf.repository;

import java.util.List;
import java.util.Optional;

import com.epf.model.Zombie;

public interface ZombieDAO {

    /**
     * Retrieves all zombies from the database.
     *
     * @return a list of all zombies.
     */
    List<Zombie> findAll();

    /**
     * Retrieves a zombie by its ID.
     *
     * @param id the ID of the zombie to retrieve.
     * @return an Optional containing the found zombie, or an empty Optional if no zombie is found.
     */
    Optional<Zombie> findById(int id);

    /**
     * Retrieves all zombies associated with a specific map ID.
     *
     * @param mapId the ID of the map to retrieve zombies for.
     * @return a list of zombies associated with the specified map ID.
     */
    List<Zombie> findByMapId(int mapId);
}
