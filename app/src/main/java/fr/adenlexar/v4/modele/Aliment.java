package fr.adenlexar.v4.modele;

import android.media.Image;

import java.io.Serializable;

public class Aliment implements Serializable {
    private String nom;
    private int poids;
    private Nutrition nutriPourCentG;
    private Nutrition nutriActuelle;
    private String imgUrl;
    private String type;
    private boolean favori;

    public Aliment(String n, Nutrition nutriPourCentG, String imgUrl, String type) {
        this.nom = n;
        this.poids = 100;
        this.nutriPourCentG = nutriPourCentG;
        this.nutriActuelle = new Nutrition(nutriPourCentG.getCalories()*poids/100,
                nutriPourCentG.getProteines()*poids/100,
                nutriPourCentG.getLipides()*poids/100,
                nutriPourCentG.getGlucides()*poids/100);
        this.imgUrl = imgUrl;
        this.type = type;
        this.favori = false;
    }


    /**
     * Getters and Setters
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public Nutrition getNutriPourCentG() {
        return nutriPourCentG;
    }

    public void setNutriPourCentG(Nutrition nutriPourCentG) {
        this.nutriPourCentG = nutriPourCentG;
    }

    public Nutrition getNutriActuelle() {
        return nutriActuelle;
    }

    public void setNutriActuelle(Nutrition nutriActuelle) {
        this.nutriActuelle = nutriActuelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isFavori() {
        return favori;
    }

    public void setFavori(boolean favori) {
        this.favori = favori;
    }
}
