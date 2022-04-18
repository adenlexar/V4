package fr.adenlexar.v4.ui.nutrition;

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

import java.util.ArrayList;

import fr.adenlexar.v4.MainActivity;
import fr.adenlexar.v4.R;
import fr.adenlexar.v4.modele.Aliment;
import fr.adenlexar.v4.modele.Nutrition;




public class NutriFragment extends Fragment {

    private MainActivity mainActivity;
    private ArrayList<Aliment> liste;
    private EditText poidsG;
    private Aliment currentAliment;

    //onclick
    //liste.add(currentAliment);
    //currentAliment = Null;


    private void ecouteBoutons(View v){
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_info, container, false);

        mainActivity = (MainActivity) getActivity();

        this.poidsG = (EditText) root.findViewById(R.id.Poids); //récupération de l'objet graphique à l'aide de l'id
        ecouteBoutons(root);
        return root;
    }
}