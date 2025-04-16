package com.epf.service;

import java.util.List;
import com.epf.model.Map;

public interface MapService {
    List<Map> findAll();
    Map findById(int id);
    void create(Map map);
    void update(Map map);
    void delete(int id);
}
