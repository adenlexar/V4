package fr.adenlexar.v4.ui.complements;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import fr.adenlexar.v4.R;

public class CompFragment extends Fragment {

    private ListView listView;
    private List list;
    private ListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_comp, container, false);
        this.listView = root.findViewById(R.id.idListView);
        this.list = new ArrayList();
        list.add("Whey Protéine"); //whey protein
        list.add("Collagène"); //collagène
        list.add("Vitamine D"); //vitamine D
        list.add("Gainer"); //gainer
        list.add("Pre-Workout"); //pre-workout
        list.add("Créatine"); //creatine
        list.add("Zinc"); //zinc
        list.add("Magnésium"); //magnésium
        list.add("Spiruline"); //spiruline

        this.adapter = new ArrayAdapter(CompFragment.this.getContext(), android.R.layout.simple_list_item_1, list);
        this.listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //When clicked

                Intent intent = new Intent(CompFragment.this.getContext(), PopUpComp.class);
                if(position == 0) {
                    intent.putExtra("TITLE", "Whey Protéine");
                    intent.putExtra("TEXT", "La whey protéine est une protéine issue du lait. Populaire auprès des pratiquants de musculation, cette dernière permet " +
                            "d'augmenter facilement son apport journalier en protéine. On la déconseille aux intolérants au lactose. On la consomme souvent sous forme de boisson avec de l'eau ou du lait");
                }
                else if(position == 1) {
                    intent.putExtra("TITLE", "Collagène");
                    intent.putExtra("TEXT", "Le collagène est un composant de notre peau et de nos tendons. Se complémenter en collagène peut s'avérer utile pour prévenir" +
                            "les blessures articulaires telles que les tendinites. Il peut se consommer en poudre ou en gélulle.");
                }
                else if(position == 2) {
                    intent.putExtra("TITLE", "Vitamine D");
                    intent.putExtra("TEXT", "");
                }
                else if(position == 3) {
                    intent.putExtra("TITLE", "Gainer");
                    intent.putExtra("TEXT", "");
                }
                else if(position == 4) {
                    intent.putExtra("TITLE", "Pré-Workout");
                    intent.putExtra("TEXT", "");
                }
                else if(position == 5) {
                    intent.putExtra("TITLE", "Créatine");
                    intent.putExtra("TEXT", "");
                }
                else if(position == 6) {
                    intent.putExtra("TITLE", "Zinc");
                    intent.putExtra("TEXT", "");
                }
                else if(position == 7) {
                    intent.putExtra("TITLE", "Magnésium");
                    intent.putExtra("TEXT", "");
                }
                else if(position == 8) {
                    intent.putExtra("TITLE", "Spiruline");
                    intent.putExtra("TEXT", "");
                }

                startActivity(intent);
            }
        });

        return root;
    }


}