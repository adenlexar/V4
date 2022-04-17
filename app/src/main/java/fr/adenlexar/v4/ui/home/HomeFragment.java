package fr.adenlexar.v4.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fr.adenlexar.v4.R;
import fr.adenlexar.v4.controleur.Controle;
import fr.adenlexar.v4.modele.Profil;
import fr.adenlexar.v4.ui.infos.InfoFragment;

public class HomeFragment extends Fragment {

    //TODO à compléter
    //propriétés graphiques output
    private TextView txtImc;
    private TextView txtMeta;
    private TextView txtMetaMai;
    private TextView txtMetaObj;

    private Controle c;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment testFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        init(root);

        return root;
    }

    /**
     * Init des liens avec les objets graphiques
     */
    private void init(View v){
        this.txtImc = (TextView) v.findViewById(R.id.idImcOutput);
        this.txtMeta = (TextView) v.findViewById(R.id.idMetaOutput);
        this.txtMetaMai = (TextView) v.findViewById(R.id.idMetaMaiOutput);
        this.txtMetaObj = (TextView) v.findViewById(R.id.idMetaObjOutput);
        this.c = Controle.getInstance();
    }

    /**
     * Affiche les infos du profil créé
     */
    private void afficheInfos(){
        //récup des infos
        if(c!=null){
            double imc = c.getImc();
            int metabolisme_basal = c.getMetabolisme_basal();
            int metabolisme_maintient =  c.getMetabolisme_maintient();
            int metabolisme_objectif = c.getMetabolisme_objectif();

            //affichage
            this.txtImc.setText(String.valueOf(imc)); //@TODO faire afficher 1 chiffre apres la virgule
            this.txtMeta.setText(String.valueOf(metabolisme_basal) + " kcal");
            this.txtMetaMai.setText(String.valueOf(metabolisme_maintient) + " kcal");
            this.txtMetaObj.setText(String.valueOf(metabolisme_objectif) + " kcal");
        }
    }
}