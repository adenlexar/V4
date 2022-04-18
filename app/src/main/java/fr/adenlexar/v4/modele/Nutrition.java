package fr.adenlexar.v4.modele;

public class Nutrition {
    private int calories;
    private int proteines;
    private int lipides;
    private int glucides;

    public Nutrition(int c, int p, int l, int g){
        this.calories = c;
        this.proteines = p;
        this.lipides = l;
        this.glucides = g;
    }

    /**
     * Getters and Setters
     */
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProteines() {
        return proteines;
    }

    public void setProteines(int proteines) {
        this.proteines = proteines;
    }

    public int getLipides() {
        return lipides;
    }

    public void setLipides(int lipides) {
        this.lipides = lipides;
    }

    public int getGlucides() {
        return glucides;
    }

    public void setGlucides(int glucides) {
        this.glucides = glucides;
    }
}
