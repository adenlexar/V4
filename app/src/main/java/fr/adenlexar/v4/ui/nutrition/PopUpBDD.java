package fr.adenlexar.v4.ui.nutrition;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.adenlexar.v4.MainActivity;
import fr.adenlexar.v4.R;
import fr.adenlexar.v4.adapter.AlimentAdapter;
import fr.adenlexar.v4.adapter.AlimentDecoration;
import fr.adenlexar.v4.modele.Aliment;
import fr.adenlexar.v4.modele.BDD;

public class PopUpBDD extends AppCompatActivity {

    private ArrayList<Aliment> bdd = new MainActivity().getBdd().getList();
    private MainActivity mainActivity;
    private RecyclerView recyclerView;
    private AlimentAdapter adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_bdd);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int w = dm.widthPixels;
        int h = dm.heightPixels;

        this.intent = getIntent();
        getWindow().setLayout((int)(w*.8), (int)(h*.8));

        getSupportActionBar().hide();

        this.bdd = (ArrayList<Aliment>) intent.getSerializableExtra("Type");
        this.mainActivity = (MainActivity) intent.getSerializableExtra("context");


        this.recyclerView = findViewById(R.id.RecyclerViewBDD);
        this.adapter  = new AlimentAdapter(R.layout.item_aliment,bdd,mainActivity);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.addItemDecoration(new AlimentDecoration());
    }

    public void setBdd(ArrayList<Aliment> bdd) {
        this.bdd = bdd;
    }
}
