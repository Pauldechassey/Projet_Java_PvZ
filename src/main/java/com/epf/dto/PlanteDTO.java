package com.epf.dto;

import com.epf.model.Effet;
import com.epf.model.Plante;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanteDTO {

    private int id;
    private String nom;
    private int point_de_vie;
    private int attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private float soleil_par_seconde;
    
    @JsonProperty("effet")
    private Effet effet;
    
    private String chemin_image;

    public PlanteDTO() {
    }

    public PlanteDTO(Plante plante) {
        this.id = plante.getId();
        this.nom = plante.getNom();
        this.point_de_vie = plante.getPoint_de_vie();
        this.attaque_par_seconde = plante.getAttaque_par_seconde();
        this.degat_attaque = plante.getDegat_attaque();
        this.cout = plante.getCout();
        this.soleil_par_seconde = plante.getSoleil_par_seconde();
        this.effet = plante.getEffet();
        this.chemin_image = plante.getChemin_image();
    }

    public Plante toEntity() {
        Plante plante = new Plante();
        plante.setId(this.id);
        plante.setNom(this.nom);
        plante.setPoint_de_vie(this.point_de_vie);
        plante.setAttaque_par_seconde(this.attaque_par_seconde);
        plante.setDegat_attaque(this.degat_attaque);
        plante.setCout(this.cout);
        plante.setSoleil_par_seconde(this.soleil_par_seconde);
        plante.setEffet(this.effet);
        plante.setChemin_image(this.chemin_image);
        return plante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public int getAttaque_par_seconde() {
        return attaque_par_seconde;
    }

    public void setAttaque_par_seconde(int attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public float getSoleil_par_seconde() {
        return soleil_par_seconde;
    }

    public void setSoleil_par_seconde(float soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public Effet getEffet() {
        return effet;
    }

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
}
