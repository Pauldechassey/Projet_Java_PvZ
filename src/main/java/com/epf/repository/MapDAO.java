package com.epf.repository;

import java.util.List;
import java.util.Optional;

import com.epf.model.Map;

public interface MapDAO {
    List<Map> findAll();
    Optional<Map> findById(int id);
}
