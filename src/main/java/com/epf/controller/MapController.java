package com.epf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.dto.MapDTO;
import com.epf.model.Map;
import com.epf.service.MapService;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping
    public List<MapDTO> getAllMaps() {
        return mapService.findAll().stream()
            .map(MapDTO::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MapDTO getMapById(@PathVariable("id")  int id) {
        return new MapDTO(mapService.findById(id));
    }

    @PostMapping
    public void createMap(@RequestBody MapDTO mapDTO) {
        mapService.create(mapDTO.toEntity());
    }

    @PutMapping("/{id}")
    public void updateMap(@PathVariable("id") int id, @RequestBody MapDTO mapDTO) {
        Map map = mapDTO.toEntity();
        map.setId_map(id);
        mapService.update(map);
    }

    @DeleteMapping("/{id}")
    public void deleteMap(@PathVariable("id")  int id) {
        mapService.delete(id);
    }
}
