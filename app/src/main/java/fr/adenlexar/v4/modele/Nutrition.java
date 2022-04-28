package fr.adenlexar.v4.modele;

import java.io.Serializable;

public class Nutrition implements Serializable {
    private double calories;
    private double proteines;
    private double lipides;
    private double glucides;

    public Nutrition(double c, double p, double l, double g){
        this.calories = c;
        this.proteines = p;
        this.lipides = l;
        this.glucides = g;
    }

    /**
     * Getters and Setters
     */
    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProteines() {
        return proteines;
    }

    public void setProteines(double proteines) {
        this.proteines = proteines;
    }

    public double getLipides() {
        return lipides;
    }

    public void setLipides(double lipides) {
        this.lipides = lipides;
    }

    public double getGlucides() {
        return glucides;
    }

    public void setGlucides(double glucides) {
        this.glucides = glucides;
    }
}
