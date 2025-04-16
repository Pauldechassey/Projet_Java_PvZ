package com.epf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.model.Map;
import com.epf.repository.MapRepository;

@Service
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;

    public MapServiceImpl(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public List<Map> findAll() {
        return mapRepository.findAll();
    }

    @Override
    public Map findById(int id) {
        return mapRepository.findById(id);
    }

    @Override
    public void create(Map map) {
        mapRepository.create(map);
    }

    @Override
    public void update(Map map) {
        mapRepository.update(map);
    }

    @Override
    public void delete(int id) {
        mapRepository.delete(id);
    }
}
