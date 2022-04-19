package fr.adenlexar.v4.controleur;

import java.text.DecimalFormat;

import fr.adenlexar.v4.R;
import fr.adenlexar.v4.modele.Nutrition;
import fr.adenlexar.v4.modele.Profil;

public final class Controle {

    private static Controle instance = null;
    private Profil profil;

    /**
     * Constructeur privée
     */
    private Controle(){
        super();
    }

    /**
     * Création de l'instance du singleton controle
     * @return instance
     */
    public static final Controle getInstance(){
        if(Controle.instance == null){
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }

    /**
     * Création du profil
     * @param nom
     * @param sexe true : homme, false : femme
     * @param age
     * @param taille (cm)
     * @param poids (kg)
     * @param activite sédentaire : 0, legerement actif : 1, actif : 2, très actif : 3, extremement actif : 4
     * @param objectif maintient : 0, maigrir : 1, grossir : 2
     */
    public void creerProfil(String nom, boolean sexe, int age, int taille, int poids, int activite, int objectif){
        this.profil = new Profil(nom, sexe, age, taille, poids, activite, objectif);
    }


    public String getNom() {
        return this.profil.getNom();
    }

    public String getSexe() {
        if(this.profil.isSexe()) return "Homme";
        else return "Femme";
    }

    public String getAge() {
        return this.profil.getAge() + " ans";
    }

    public String getTaille() {
        return this.profil.getTaille() + " cm";
    }

    public String getPoids() {
        return this.profil.getPoids() + " kg";
    }

    public String getActivite() {
        if(this.profil.getActivite() == 0) return "Sédentaire";
        else if(this.profil.getActivite() == 1) return "Légèrement Actif";
        else if(this.profil.getActivite() == 2) return "Actif";
        else if(this.profil.getActivite() == 3) return "Très Actif";
        else return "Extrêmement Actif";
    }

    public String getObjectif() {
        if(this.profil.getObjectif() == 0) return "Maintient";
        else if(this.profil.getObjectif() == 1) return "Perte de masse grasse";
        else return "Prise de masse musculaire";
    }

    /**
     * récupération de l'imc de profil
     * @return imc
     */
    public String getImc(){
        DecimalFormat df = new DecimalFormat("0.0");
        return "IMC : " + String.valueOf(df.format(this.profil.getImc()));
    }

    /**
     * récupération du métabolisme basal de profil
     * @return imc
     */
    public String getMetabolisme_basal() {
        return "Metabolisme basal : " + String.valueOf(this.profil.getMetabolisme_basal()) + " kcal";
    }

    /**
     * récupération du métabolisme de maintient de profil
     * @return imc
     */
    public String getMetabolisme_maintient() {
        return "Metabolisme maintient : " + String.valueOf(this.profil.getMetabolisme_maintient())  + " kcal";
    }

    /**
     * récupération du métabolisme de l'objectif de profil
     * @return imc
     */
    public String getMetabolisme_objectif() {
        return "Ton objectif : " + String.valueOf(this.profil.getMetabolisme_objectif())  + " kcal";
    }

    public void setActualConso(Nutrition n){
        this.profil.setActualConso(n);
    }
}
