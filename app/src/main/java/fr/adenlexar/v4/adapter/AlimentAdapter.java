package fr.adenlexar.v4.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

import fr.adenlexar.v4.MainActivity;
import fr.adenlexar.v4.R;
import fr.adenlexar.v4.modele.Aliment;

public class AlimentAdapter extends RecyclerView.Adapter<AlimentAdapter.ViewHolder> {

    private int layoutId;
    private ArrayList<Aliment> liste;
    private MainActivity context;

    //Custom ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nomText;
        private final TextView poidsText;
        private final ImageView alimentIcon;
        private final ImageButton alimentButton;

        private MainActivity context;

        public ViewHolder(View view){
            super(view);

            nomText = (TextView) view.findViewById(R.id.Nom_Aliment);
            poidsText = (TextView) view.findViewById(R.id.Poids_Aliment);
            alimentIcon = (ImageView) view.findViewById(R.id.Icone_Aliment);
            alimentButton = (ImageButton) view.findViewById(R.id.Image_item);
        }

        public TextView getNomText(){
            return nomText;
        }

        public TextView getPoidsText() {
            return poidsText;
        }

        public ImageView getAlimentIcon() {
            return alimentIcon;
        }
    }


    public AlimentAdapter (int layoutId, ArrayList<Aliment> liste, MainActivity context){
        this.liste = liste;
        this.layoutId = layoutId;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(layoutId, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Aliment currentAliment = liste.get(position);
        Glide.with(context).load(Uri.parse(currentAliment.getImgUrl())).into(viewHolder.alimentButton);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return liste.size();
    }
}
