package com.epf.repository;

import java.util.List;

import com.epf.model.Map;

public interface MapDAO {
    List<Map> findAll();
    Map findById(int id);
    void create(Map map);
    void update(Map map);
    void delete(int id);
}
