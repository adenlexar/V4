package fr.adenlexar.v4.modele;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BDD implements Serializable {
    private ArrayList<Aliment> list;
    private ArrayList<Aliment> Fruit;
    private ArrayList<Aliment> Legumes;
    private ArrayList<Aliment> Viande;
    private ArrayList<Aliment> Poisson;
    private ArrayList<Aliment> Autres;

    public BDD(ArrayList<Aliment> list){
        this.list = list;
        this.Fruit = new ArrayList<>();
        this.Legumes = new ArrayList<>();
        this.Viande = new ArrayList<>();
        this.Poisson = new ArrayList<>();
        this.Autres = new ArrayList<>();
    }

    public void addAliment(Aliment e){
        this.list.add(e);
        if(e.getType().equals("Fruit")) {
            Fruit.add(e);
        } else if (e.getType().equals("Legumes")){
            Legumes.add(e);
        } else if (e.getType().equals("Viande")){
            Viande.add(e);
        } else if (e.getType().equals("Poisson")){
            Poisson.add(e);
        } else {
            Autres.add(e);
        }
    }


    /**
     * Getters and Setters
     */
    public ArrayList<Aliment> getList(){
        return this.list;
    }

    public void setList(ArrayList<Aliment> l){
        this.list = l;
    }

    public ArrayList<Aliment> getFruit() {
        return Fruit;
    }

    public void setFruit(ArrayList<Aliment> fruit) {
        Fruit = fruit;
    }

    public ArrayList<Aliment> getLegumes() {
        return Legumes;
    }

    public void setLegumes(ArrayList<Aliment> legumes) {
        Legumes = legumes;
    }

    public ArrayList<Aliment> getViande() {
        return Viande;
    }

    public void setViande(ArrayList<Aliment> viande) {
        Viande = viande;
    }

    public ArrayList<Aliment> getPoisson() {
        return Poisson;
    }

    public void setPoisson(ArrayList<Aliment> poisson) {
        Poisson = poisson;
    }

    public ArrayList<Aliment> getAutres() {
        return Autres;
    }

    public void setAutres(ArrayList<Aliment> autres) {
        Autres = autres;
    }
}
