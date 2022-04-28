package fr.adenlexar.v4.ui.complements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import fr.adenlexar.v4.R;
import fr.adenlexar.v4.ui.complements.CompFragment;

public class PopUpComp extends AppCompatActivity {

    private TextView txtTitle;
    private TextView txtTxt;
    private Intent intent;
    private ImageButton bouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int w = dm.widthPixels;
        int h = dm.heightPixels;

        getWindow().setLayout((int)(w*.8), (int)(h*.8));

        getSupportActionBar().hide();

        this.txtTitle = findViewById(R.id.idCompName);
        this.txtTxt = findViewById(R.id.idCompTxt);
        this.bouton = findViewById(R.id.CloseButton);

        bouton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }

        });

        this.intent = getIntent();
        this.txtTitle.setText(intent.getStringExtra("TITLE"));
        this.txtTxt.setText(intent.getStringExtra("TEXT"));
    }
}