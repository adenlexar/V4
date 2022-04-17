package fr.adenlexar.v4.ui.infos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fr.adenlexar.v4.R;
import fr.adenlexar.v4.controleur.Controle;
import fr.adenlexar.v4.modele.Profil;
import fr.adenlexar.v4.ui.home.HomeFragment;

public class InfoFragment extends Fragment {

    //propriétés graphiques input
    private EditText txtNom;
    private RadioButton rdHomme;
    private EditText txtAge;
    private EditText txtTaille;
    private EditText txtPoids;
    private Spinner spiAct;
    private Spinner spiObj;

    Controle c;

    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment testFragment.
     */
    public static InfoFragment newInstance() {
        InfoFragment fragment = new InfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);
        init(root);
        return root;
    }

    /**
     * Init des liens avec les objets graphiques
     */
    private void init(View v){
        this.txtNom = (EditText) v.findViewById(R.id.idNameInput); //récupération de l'objet graphique à l'aide de l'id
        this.rdHomme = (RadioButton) v.findViewById(R.id.idMaleRd);
        this.txtAge = (EditText) v.findViewById(R.id.idAgeInput);
        this.txtTaille = (EditText) v.findViewById(R.id.idHeightInput);
        this.txtPoids = (EditText) v.findViewById(R.id.idWeightInput);
        this.spiAct = (Spinner) v.findViewById(R.id.idActInput);
        this.spiObj = (Spinner) v.findViewById(R.id.idObjInput);

        this.c = Controle.getInstance();
        ecouteCalcul(v);
    }

    private void ecouteCalcul(View v){
        ((Button) v.findViewById(R.id.idCalcButton)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                Log.d("msg", "************************************bouton !");
                String nom = "???";
                boolean sexe = true;
                int age = 0;
                int taille = 0;
                int poids = 0;
                int act = 0;
                int obj = 0;

                //récup données saisies
                nom = txtNom.getText().toString();
                sexe = rdHomme.isChecked();
                try{
                    age = Integer.parseInt(txtAge.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    poids = Integer.parseInt(txtPoids.getText().toString());
                }catch(Exception e){};
                act = spiAct.getSelectedItemPosition();
                obj = spiObj.getSelectedItemPosition();

                //controle des données saisies
                if(age == 0 || taille == 0 || poids == 0){
                    //Toast.makeText(MainActivity.this,"saisie incorrecte",Toast.LENGTH_SHORT).show();
                }
                else{
                    creeInfos(nom, sexe, age, taille, poids, act, obj);
                }
            }
        });
    }

    /**
     * Créé les infos du profil créé
     * @param nom
     * @param sexe
     * @param age
     * @param taille
     * @param poids
     * @param activite
     * @param objectif
     */
    private void creeInfos(String nom, boolean sexe, int age, int taille, int poids, int activite, int objectif){
        //Création profil
        this.c.creerProfil(nom,sexe,age,taille,poids,activite,objectif);
        Log.d("msg", "************************************profil !" + c.getImc());
    }
}