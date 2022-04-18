package fr.adenlexar.v4.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import fr.adenlexar.v4.ui.infos.InfoFragment;
import fr.adenlexar.v4.ui.nutrition.NutriViewModel;

public class HomeFragment extends Fragment {

    //attributs graphiques
    private TextView txtNom;
    private TextView txtSexe;
    private TextView txtAge;
    private TextView txtTaille;
    private TextView txtPoids;
    private TextView txtAct;
    private TextView txtObj;

    private TextView txtImc;
    private TextView txtMeta;
    private TextView txtMetaMai;
    private TextView txtMetaObj;

    private HomeViewModel homeViewModel;
    private MainActivity mainActivity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        mainActivity = (MainActivity) getActivity();

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        this.txtNom = (TextView) root.findViewById(R.id.idNameOutput);
        this.txtSexe = (TextView) root.findViewById(R.id.idSexeOutput);
        this.txtAge = (TextView) root.findViewById(R.id.idAgeOutput);
        this.txtTaille = (TextView) root.findViewById(R.id.idHeightOutput);
        this.txtPoids = (TextView) root.findViewById(R.id.idWeightOutput);
        this.txtAct = (TextView) root.findViewById(R.id.idActOutput);
        this.txtObj = (TextView) root.findViewById(R.id.idObjOutput);

        this.txtImc = (TextView) root.findViewById(R.id.idImcOutput);
        this.txtMeta = (TextView) root.findViewById(R.id.idMetaOutput);
        this.txtMetaMai = (TextView) root.findViewById(R.id.idMetaMaiOutput);
        this.txtMetaObj = (TextView) root.findViewById(R.id.idMetaObjOutput);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //les changements à faire sur les view
            }
        });
        afficheInfos();
        return root;
    }

    /**
     * Affiche les infos du profil créé
     */

    private void afficheInfos(){
        //récup des infos
        try{
            Controle c = mainActivity.getC();


            String imc = c.getImc();
            String metabolisme_basal = c.getMetabolisme_basal();
            String metabolisme_maintient =  c.getMetabolisme_maintient();
            String metabolisme_objectif = c.getMetabolisme_objectif();

            //affichage
            this.txtNom.setText(c.getNom());
            this.txtSexe.setText(c.getSexe());
            this.txtAge.setText(c.getAge());
            this.txtTaille.setText(c.getTaille());
            this.txtPoids.setText(c.getPoids());
            this.txtAct.setText(c.getActivite());
            this.txtObj.setText(c.getObjectif());

            this.txtImc.setText(c.getImc()); //@TODO faire afficher 1 chiffre apres la virgule
            this.txtMeta.setText(c.getMetabolisme_basal());
            this.txtMetaMai.setText(c.getMetabolisme_maintient());
            this.txtMetaObj.setText(c.getMetabolisme_objectif());
        }
        catch(Exception e){}
    }


}