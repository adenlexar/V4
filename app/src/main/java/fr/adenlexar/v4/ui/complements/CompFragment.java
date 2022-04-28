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
                    intent.putExtra("TEXT", "Le collagène est un composant de notre peau et de nos tendons. Se complémenter en collagène peut s'avérer utile pour prévenir " +
                            "les blessures articulaires telles que les tendinites. Il peut se consommer en poudre ou en gélulle.");
                }
                else if(position == 2) {
                    intent.putExtra("TITLE", "Vitamine D");
                    intent.putExtra("TEXT", "La vitamine D est un micronutriment essentiel au bon fonctionnement du corps humain (permet la fixation du calcium et autre)."+
                            "On la retrouve dans les poissons gras mais on peut aussi en synthétiser naturellement en s'exposant au soleil. Or en hiver on se retrouve souvent en situtation de carence et se complémenter peut alors être une bonne idée. +" +
                            " On déconseille les cures de vitamine D prescrites par les médecins car celles-ci surdosent les besoins journaliers et ne durent qu'un mois. On préférera un apport journalier d'environ 3 microgrammes.");
                }
                else if(position == 3) {
                    intent.putExtra("TITLE", "Gainer");
                    intent.putExtra("TEXT", "Le gainer est un complément alimentaire utilisé par les personnes en prise de masse musculaire. Il permet d'augmenter son nombre de kilocalories" +
                            " journalier et ce sous forme d'une poudre contenant glucides et protéines." +" On déconseille les gainer trop riches en sucres rapides car ceux-ci sont moins bon pour la santé que ceux à base de "+
                            "sucre lent comme la poudre d'avoine par exemple.");
                }
                else if(position == 4) {
                    intent.putExtra("TITLE", "Pré-Workout");
                    intent.putExtra("TEXT", "Le pré-workout est un complément à prendre avant sa séance de sport. Souvent à base de caffeine, il permet un regain d'énergie pour ne pas se sentir fatigué à l'entraînement."+
                            "Il ne faut pas trop en consommer car la caffeine à haute dose peut être dangereux pour la santé.");
                }
                else if(position == 5) {
                    intent.putExtra("TITLE", "Créatine");
                    intent.putExtra("TEXT", "La créatine est un complément possédant de nombreuses vertues : " +
                            " amélioration de la synthèse des protéines et du glycogène, renforcement du système immunitaire, augmentation de la force, des fonctions cérébrales etc. On recommande d'en prendre environ 2g par jour.");
                }
                else if(position == 6) {
                    intent.putExtra("TITLE", "Zinc");
                    intent.putExtra("TEXT", "Le zinc favorise le processus de cicatrisation des plaies et aide à lutter contre les problèmes de peau. Il agit en tant qu'antioxydant en neutralisant les radicaux libres, protège les cellules de la peau, et participe à la pousse des cheveux et des ongles.");
                }
                else if(position == 7) {
                    intent.putExtra("TITLE", "Magnésium");
                    intent.putExtra("TEXT", "Il est conseillé pour améliorer l'endurance, les performances chez les sportifs, et l'asthme. Il est utile également pour traiter les crampes musculaires, diminuer la fatigue, le stress, l'anxiété, l'insomnie");
                }
                else if(position == 8) {
                    intent.putExtra("TITLE", "Spiruline");
                    intent.putExtra("TEXT", "Puissant antioxydant, la spiruline aide à soutenir les fonctions d'élimination de notre organisme et à lutter contre la formation des radicaux libres responsables du stress oxydatif. ");
                }

                startActivity(intent);
            }
        });

        return root;
    }


}