package com.epf.model;

public class Zombie {
    private int id_zombie;
    private String nom;
    private int point_de_vie;
    private float attaque_par_seconde;
    private int degat_attaque;
    private float vitesse_de_deplacement;
    private String chemin_image;
    private int id_map;

    public Zombie() {
    }

    public Zombie(int id_zombie, String nom, int point_de_vie, float attaque_par_seconde,
            int degat_attaque, float vitesse_de_deplacement, String chemin_image, int id_map) {
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.chemin_image = chemin_image;
        this.id_map = id_map;
    }

    // Getters et Setters
    public Zombie getZombie() {
        return this;
    }

    public int getId_zombie() {
        return id_zombie;
    }

    public void setId_zombie(int id_zombie) {
        this.id_zombie = id_zombie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoint_de_vie() {
        return this.point_de_vie;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public float getAttaque_par_seconde() {
        return this.attaque_par_seconde;
    }

    public void setAttaque_par_seconde(float attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public int getDegat_attaque() {
        return this.degat_attaque;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public float getVitesse_de_deplacement() {
        return this.vitesse_de_deplacement;
    }

    public void setVitesse_de_deplacement(float vitesse_de_deplacement) {
        this.vitesse_de_deplacement = vitesse_de_deplacement;
    }

    public String getChemin_image() {
        return this.chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public int getId_map() {
        return this.id_map;
    }

    public void setId_map(int id_map) {
        this.id_map = id_map;
    }

    public Boolean getZombieMap(Map M){
        return this.id_map == M.getId_map();
    }

    @Override
    public String toString() {
        return "Zombie{" +
                "id_zombie=" + this.id_zombie +
                ", nom='" + this.nom + '\'' +
                ", point_de_vie=" + this.point_de_vie +
                ", attaque_par_seconde=" + this.attaque_par_seconde +
                ", degat_attaque=" + this.degat_attaque +
                ", vitesse_de_deplacement=" + this.vitesse_de_deplacement +
                ", chemin_image='" + this.chemin_image + '\'' +
                ", id_map=" + this.id_map +
                '}';
    }
}