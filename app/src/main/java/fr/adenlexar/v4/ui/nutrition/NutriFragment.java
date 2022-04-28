package fr.adenlexar.v4.ui.nutrition;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import fr.adenlexar.v4.MainActivity;
import fr.adenlexar.v4.R;
import fr.adenlexar.v4.adapter.AlimentAdapter;
import fr.adenlexar.v4.modele.Aliment;
import fr.adenlexar.v4.modele.BDD;
import fr.adenlexar.v4.modele.Nutrition;


public class NutriFragment extends Fragment {

    private MainActivity mainActivity;
    private EditText poidsG;
    private TextView Nom;
    private ImageButton img;
    private Aliment currentAliment;
    private RecyclerView recyclerView;
    private BDD bdd = new MainActivity().getBdd();
    private ArrayList<Aliment> liste = new ArrayList<>();
    private AlimentAdapter adapter;
    private PopUpNutri popup = new PopUpNutri();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_nutri, container, false);

        mainActivity = (MainActivity) getActivity();

        this.adapter = new AlimentAdapter(R.layout.item_vertical_aliment,liste,mainActivity);

        this.recyclerView = (RecyclerView) root.findViewById(R.id.VerticalRecyclerView);

        recyclerView.setAdapter(adapter);
        this.img = (ImageButton) root.findViewById(R.id.image);
        this.Nom = (TextView) root.findViewById(R.id.Nom);
        this.poidsG = (EditText) root.findViewById(R.id.Poids);//récupération de l'objet graphique à l'aide de l'id

        ecouteBoutons(root);

        return root;
    }

    private void ecouteBoutons(View v){
        ((Button) v.findViewById(R.id.Manger)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                int poids = 0;
                String nom = "";
                currentAliment = null;

                //récup données saisies
                try {
                    poids = Integer.parseInt(poidsG.getText().toString());
                } catch (Exception e) {};
                nom = Nom.getText().toString();
                if (poids == 0 || nom.equals("")) {
                    //Problème
                } else {
                    currentAliment = new Aliment(nom,null,"","");//A remettre dans la recherche
                    liste.add(currentAliment);
                    currentAliment  = null;
                    mainActivity.getC().setActualConso(calculTotal());
                }
            }
        });

        img.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                popup.setBdd(bdd);
                Intent intent = new Intent(NutriFragment.this.getContext(), popup.getClass());
                intent.putExtra("context",mainActivity);

                startActivity(intent);
            }
        });
    }

    private Nutrition calculTotal(){
        double c = 0;
        double p = 0;
        double l = 0;
        double g = 0;
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

    @Nullable
    private Nutrition chercheNutri(String nom){
        return null;
    }

    @Nullable
    private Image chercheImg(String nom){
        return null;
    }
}