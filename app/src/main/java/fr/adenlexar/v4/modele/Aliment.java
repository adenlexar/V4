package fr.adenlexar.v4.modele;

import android.media.Image;

public class Aliment {
    private String nom;
    private int poids;
    private Nutrition nutriPourCentG;
    private Nutrition nutriActuelle;
    private Image img;

    public Aliment(String n, int poids, Nutrition nutriPourCentG, Image img) {
        this.nom = n;
        this.poids = poids;
        this.nutriPourCentG = nutriPourCentG;
        this.nutriActuelle = new Nutrition(nutriPourCentG.getCalories()*poids/100,
                nutriPourCentG.getProteines()*poids/100,
                nutriPourCentG.getLipides()*poids/100,
                nutriPourCentG.getGlucides()*poids/100);
        this.img = img;
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
}
