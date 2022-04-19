package fr.adenlexar.v4.ui.nutrition;

import android.media.Image;
import android.os.Bundle;
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
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.adenlexar.v4.MainActivity;
import fr.adenlexar.v4.R;
import fr.adenlexar.v4.modele.Aliment;
import fr.adenlexar.v4.modele.Nutrition;




public class NutriFragment extends Fragment {

    private MainActivity mainActivity;
    private ArrayList<Aliment> liste;
    private EditText poidsG;
    private TextView Nom;
    private Aliment currentAliment;
    private RecyclerView recyclerView;

    private Nutrition calculTotal(){
        int c = 0;
        int p = 0;
        int l = 0;
        int g = 0;
        Nutrition n = null;
        for (int i = 0 ; i < liste.toArray().length ; i ++) {
            n = liste.get(i).getNutriActuelle();
            c += n.getCalories();
            p += n.getProteines();
            l += n.getLipides();
            g += n.getGlucides();
        }
        return new Nutrition(c,p,l,g);
    }

    private void ecouteBoutons(View v){
        ((Button) v.findViewById(R.id.Manger)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                int poids = 0;
                String nom = "";
                currentAliment = null;

                //récup données saisies
                poids = Integer.parseInt(poidsG.getText().toString());
                nom = Nom.getText().toString();
                if (poids == 0 || nom.equals("")) {
                    //Problème
                } else {
                    currentAliment = new Aliment(nom,poids,null,null); //A remettre dans la recherche
                    liste.add(currentAliment);
                    currentAliment  = null;
                    mainActivity.getC().setActualConso(calculTotal());
                }
            }
        });
    }

    private Nutrition chercheNutri(String nom){
        return null;
    }

    private Image chercheImg(String nom){
        return null;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_info, container, false);

        mainActivity = (MainActivity) getActivity();

        this.Nom = (TextView) root.findViewById(R.id.Nom);
        this.poidsG = (EditText) root.findViewById(R.id.Poids); //récupération de l'objet graphique à l'aide de l'id
        ecouteBoutons(root);
        return root;
    }

}