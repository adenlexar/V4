package fr.adenlexar.v4.ui.nutrition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

import fr.adenlexar.v4.MainActivity;
import fr.adenlexar.v4.R;
import fr.adenlexar.v4.modele.Aliment;
import fr.adenlexar.v4.modele.BDD;
import fr.adenlexar.v4.ui.complements.CompFragment;
import fr.adenlexar.v4.ui.complements.PopUpComp;

public class PopUpNutri extends AppCompatActivity {
    private Button F;
    private Button L;
    private Button V;
    private Button P;
    private Button A;
    private Intent intent;
    private BDD bdd = new MainActivity().getBdd();
    private PopUpBDD popup2;
    private MainActivity mainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pop_up_nutri);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int w = dm.widthPixels;
        int h = dm.heightPixels;

        getWindow().setLayout((int)(w*.8), (int)(h*.8));

        getSupportActionBar().hide();

        this.mainActivity = (MainActivity) intent.getSerializableExtra("context");

        this.F = findViewById(R.id.FRUITS);  //1
        this.L = findViewById(R.id.LEGUMES);  //2
        this.V = findViewById(R.id.VIANDE);  //3
        this.P = findViewById(R.id.POISSON);  //4
        this.A = findViewById(R.id.AUTRES);  //5

        this.intent = getIntent();

        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PopUpNutri.this, PopUpBDD.class);
                intent.putExtra("Type", bdd.getFruit());
                intent.putExtra("context", mainActivity);
                startActivity(intent);
            }
        });
    }

    public BDD getBdd() {
        return bdd;
    }

    public void setBdd(BDD bdd) {
        this.bdd = bdd;
    }
}
