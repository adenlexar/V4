package fr.adenlexar.v4;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.transition.Transition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.adenlexar.v4.controleur.Controle;
import fr.adenlexar.v4.modele.Aliment;
import fr.adenlexar.v4.modele.BDD;
import fr.adenlexar.v4.modele.Nutrition;
import fr.adenlexar.v4.modele.Profil;

public class MainActivity extends AppCompatActivity implements Serializable {

    private Controle c;
    private BDD bdd;

    public MainActivity(){
        this.bdd = creationBDD();
    }

    public BDD creationBDD(){
        //-------------------------------------------Création de la BDD--------------------------------------------------------
        bdd = new BDD(new ArrayList<Aliment>());
        String fruit = "Fruit";

        bdd.addAliment(new Aliment("Abricot" , new Nutrition(50,	0.8,0.2,11.2) ,"", fruit));
        bdd.addAliment(new Aliment("Ananas" , new Nutrition(51,	0.5,0.2,12) ,"", fruit));
        bdd.addAliment(new Aliment("Avocat" , new Nutrition(167,	2.1,16.4,4.7) ,"", fruit));
        bdd.addAliment(new Aliment("Banane" , new Nutrition(90,	1.4,0.5,20) ,"", fruit));
        bdd.addAliment(new Aliment("Cacahuète" , new Nutrition(560,	23,40,26) ,"", fruit));
        bdd.addAliment(new Aliment("Cassis" , new Nutrition(65,	1.3,0.4,16) ,"", fruit));
        bdd.addAliment(new Aliment("Cerise" , new Nutrition(77,	1.2,0.5,17) ,"", fruit));
        bdd.addAliment(new Aliment("Châtaigne" , new Nutrition(207,	3.7,2.3,42.8) ,"", fruit));
        bdd.addAliment(new Aliment("Citron" , new Nutrition(40,	0.8,0.6,7.8) ,"", fruit));
        bdd.addAliment(new Aliment("Figue" , new Nutrition(74,	1.1,0.3,16.6) ,"", fruit));
        bdd.addAliment(new Aliment("Fraise" , new Nutrition(36,	0.7,0.5,7) ,"", fruit));
        bdd.addAliment(new Aliment("Framboise" , new Nutrition(40,	1,0.6,8) ,"", fruit));
        bdd.addAliment(new Aliment("Goyave" , new Nutrition(76,	0.7,0.6,17) ,"", fruit));
        bdd.addAliment(new Aliment("Grenade" , new Nutrition(66,	0.3,0.1,16) ,"", fruit));
        bdd.addAliment(new Aliment("Groseille" , new Nutrition(41,	1.1,0.2,8.6) ,"", fruit));
        bdd.addAliment(new Aliment("Kiwi" , new Nutrition(42,	0.7,0.4,9) ,"", fruit));
        bdd.addAliment(new Aliment("Litchi" , new Nutrition(68,	0.7,0.1,16) ,"", fruit));
        bdd.addAliment(new Aliment("Mandarine" , new Nutrition(52,	0.7,0.3,11.6) ,"", fruit));
        bdd.addAliment(new Aliment("Mangue" , new Nutrition(64,	0.4,0.2,15) ,"", fruit));
        bdd.addAliment(new Aliment("Melon" , new Nutrition(31,	0.8,0.2,6.5) ,"", fruit));
        bdd.addAliment(new Aliment("Mirabelle" , new Nutrition(45,	0.7,0.2,10) ,"", fruit));
        bdd.addAliment(new Aliment("Mûre" , new Nutrition(57,	1,0.6,12) ,"", fruit));
        bdd.addAliment(new Aliment("Myrtille" , new Nutrition(69,	0.6,0.6,15.3) ,"", fruit));
        bdd.addAliment(new Aliment("Nectarine" , new Nutrition(64,	0.7,0.1,15) ,"", fruit));
        bdd.addAliment(new Aliment("Noisette" , new Nutrition(656,	14,60,15) ,"", fruit));
        bdd.addAliment(new Aliment("Noix" , new Nutrition(677,	15,62.2,14.3) ,"", fruit));
        bdd.addAliment(new Aliment("Noix de coco" , new Nutrition(370,	4,35,10) ,"", fruit));
        bdd.addAliment(new Aliment("Olive verte" , new Nutrition(207,	0.8,20,6) ,"", fruit));
        bdd.addAliment(new Aliment("Olive noire" , new Nutrition(156,	1.6,15,3.5) ,"", fruit));
        bdd.addAliment(new Aliment("Orange" , new Nutrition(50,	0.5,0.1,11.7) ,"", fruit));
        bdd.addAliment(new Aliment("Pamplemousse" , new Nutrition(41,	0.6,0.2,9.2) ,"", fruit));
        bdd.addAliment(new Aliment("Papaye" , new Nutrition(44,	0.2,0.6,10) ,"", fruit));
        bdd.addAliment(new Aliment("Pastèque" , new Nutrition(25,	0.4,0.2,5.3) ,"", fruit));
        bdd.addAliment(new Aliment("Pêche" , new Nutrition(50,	0.6,0.1,11.6) ,"", fruit));
        bdd.addAliment(new Aliment("Pistache" , new Nutrition(638,	4,54.5,15.2) ,"", fruit));
        bdd.addAliment(new Aliment("Poire" , new Nutrition(61,	0.4,0.4,14) ,"", fruit));
        bdd.addAliment(new Aliment("Pomme" , new Nutrition(52,	0.30,0.2,19.2) ,"", fruit));
        bdd.addAliment(new Aliment("Prune" , new Nutrition(50,	0.8,0.2,11.2) ,"", fruit));
        bdd.addAliment(new Aliment("Pruneau" , new Nutrition(290,	2.3,0.4,70) ,"", fruit));
        bdd.addAliment(new Aliment("Raisin" , new Nutrition(81,	1,1,17) ,"", fruit));
        bdd.addAliment(new Aliment("Raisin sec" , new Nutrition(311,	1.1,0.1,76.5) ,"", fruit));
        bdd.addAliment(new Aliment("Rhubarbe" , new Nutrition(19,	0.6,0.1,3.8) ,"", fruit));
        bdd.addAliment(new Aliment("Tomate" , new Nutrition(15,	0.8,0.1,2.8) ,"", fruit));

        String legumes = "Légumes";
        bdd.addAliment(new Aliment("Ail" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Artichaut" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Asperge" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Aubergine" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Betterave" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Brocoli" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Carotte" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Céleri" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Champignon" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Chou" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Chou-fleur" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Concombre" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Cornichon" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Chou" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));
        bdd.addAliment(new Aliment("Cho" , new Nutrition(135,	6,0.1,27.5) ,"", legumes));

        //------------------------------------------------------------------------------------------------------------------------------
        return bdd;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_info, R.id.navigation_nutri, R.id.navigation_comp)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        this.c = Controle.getInstance();

    }

    public Controle getC() {
        return c;
    }

    public BDD getBdd() {
        return bdd;
    }

    public void setBdd(BDD bdd) {
        this.bdd = bdd;
    }
}