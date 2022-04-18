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

import fr.adenlexar.v4.MainActivity;
import fr.adenlexar.v4.R;
import fr.adenlexar.v4.controleur.Controle;
import fr.adenlexar.v4.modele.Profil;
import fr.adenlexar.v4.ui.home.HomeFragment;
import fr.adenlexar.v4.ui.home.HomeViewModel;

public class InfoFragment extends Fragment {

    //propriétés graphiques input
    private EditText txtNom;
    private RadioButton rdHomme;
    private EditText txtAge;
    private EditText txtTaille;
    private EditText txtPoids;
    private Spinner spiAct;
    private Spinner spiObj;
    private InfoViewModel infoViewModel;
    private MainActivity mainActivity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        infoViewModel =
                ViewModelProviders.of(this).get(InfoViewModel.class); //la classe infoView
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        mainActivity = (MainActivity) getActivity();

        this.txtNom = (EditText) root.findViewById(R.id.idNameInput); //récupération de l'objet graphique à l'aide de l'id
        this.rdHomme = (RadioButton) root.findViewById(R.id.idMaleRd);
        this.txtAge = (EditText) root.findViewById(R.id.idAgeInput);
        this.txtTaille = (EditText) root.findViewById(R.id.idHeightInput);
        this.txtPoids = (EditText) root.findViewById(R.id.idWeightInput);
        this.spiAct = (Spinner) root.findViewById(R.id.idActInput);
        this.spiObj = (Spinner) root.findViewById(R.id.idObjInput);
        ecouteCalcul(root);
        return root;
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
                    mainActivity.getC().creerProfil(nom,sexe,age,taille,poids,act,obj);
                    Log.d("msg", "************************************ profil !" + mainActivity.getC().getImc());
                }
            }
        });
    }
}