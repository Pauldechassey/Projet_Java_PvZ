package com.epf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.dao.MapDAO;
import com.epf.model.Map;

@Service
public class MapService {

    private final MapDAO mapDAO;

    public MapService(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    public List<Map> findAll() {
        return mapDAO.findAll();
    }

    public Map findById(int id) {
        return mapDAO.findById(id);
    }

    public void create(Map map) {
        mapDAO.create(map);
    }

    public void update(Map map) {
        mapDAO.update(map);
    }

    public void delete(int id) {
        mapDAO.delete(id);
    }
}
