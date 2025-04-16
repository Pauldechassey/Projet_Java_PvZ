package com.epf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.epf.dto.MapDTO;
import com.epf.model.Map;
import com.epf.service.MapService;

@RestController
@RequestMapping("/map")
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
    public MapDTO getMapById(@PathVariable int id) {
        return new MapDTO(mapService.findById(id));
    }

    @PostMapping
    public void createMap(@RequestBody MapDTO mapDTO) {
        mapService.create(mapDTO.toEntity());
    }

    @PutMapping("/{id}")
    public void updateMap(@PathVariable int id, @RequestBody MapDTO mapDTO) {
        Map map = mapDTO.toEntity();
        map.setId_map(id); // On s'assure que l'ID vient bien du path
        mapService.update(map);
    }

    @DeleteMapping("/{id}")
    public void deleteMap(@PathVariable int id) {
        mapService.delete(id);
    }
}
