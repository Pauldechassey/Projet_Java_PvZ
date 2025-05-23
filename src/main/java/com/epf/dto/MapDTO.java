package com.epf.dto;

import com.epf.model.Map;

public class MapDTO {

    private int id_map;
    private int ligne;
    private int colonne;
    private String chemin_image;

    public MapDTO() {
    }

    public MapDTO(Map map) {
        this.id_map = map.getId_map();
        this.ligne = map.getLigne();
        this.colonne = map.getColonne();
        this.chemin_image = map.getChemin_image();
    }

    public Map toEntity() {
        Map map = new Map();
        map.setId_map(this.id_map);
        map.setLigne(this.ligne);
        map.setColonne(this.colonne);
        map.setChemin_image(this.chemin_image);
        return map;
    }

    public int getId_map() {
        return id_map;
    }

    public void setId_map(int id_map) {
        this.id_map = id_map;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
}
