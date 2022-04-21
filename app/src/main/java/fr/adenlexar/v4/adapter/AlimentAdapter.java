package fr.adenlexar.v4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;



import fr.adenlexar.v4.R;

public class AlimentAdapter extends RecyclerView.Adapter<AlimentAdapter.ViewHolder> {



    //Custom ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nomText;
        private final TextView poidsText;
        private final ImageView alimentIcon;

        public ViewHolder(View view){
            super(view);

            nomText = (TextView) view.findViewById(R.id.Nom_Aliment);
            poidsText = (TextView) view.findViewById(R.id.Poids_Aliment);
            alimentIcon = (ImageView) view.findViewById(R.id.Icone_Aliment);
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


    public AlimentAdapter (){
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_vertical_aliment, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 12;
    }
}
