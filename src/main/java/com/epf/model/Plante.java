package com.epf.model;

public class Plante {
    private int id;
    private String nom;
    private int point_de_vie;
    private int attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private float soleil_par_seconde;
    private Effet effet;
    private String chemin_image;

    public Plante() {
    }

    public Plante(int id, String nom, int point_de_vie, int attaque_par_seconde,
            int degat_attaque, int cout, float soleil_par_seconde,
            Effet effet, String chemin_image) {
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.cout = cout;
        this.soleil_par_seconde = soleil_par_seconde;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }

    // Getters et Setters
    public Plante getPlante() {
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
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

    public int getAttaque_par_seconde() {
        return this.attaque_par_seconde;
    }

    public void setAttaque_par_seconde(int attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public int getDegat_attaque() {
        return this.degat_attaque;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public int getCout() {
        return this.cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public float getSoleil_par_seconde() {
        return this.soleil_par_seconde;
    }

    public void setSoleil_par_seconde(float soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public Effet getEffet() {
        return this.effet;
    }

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    public String getChemin_image() {
        return this.chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "id=" + this.id +
                ", nom='" + this.nom + '\'' +
                ", point_de_vie=" + this.point_de_vie +
                ", attaque_par_seconde=" + this.attaque_par_seconde +
                ", degat_attaque=" + this.degat_attaque +
                ", cout=" + this.cout +
                ", soleil_par_seconde=" + this.soleil_par_seconde +
                ", effet=" + this.effet +
                ", chemin_image='" + this.chemin_image + '\'' +
                '}';
    }
}