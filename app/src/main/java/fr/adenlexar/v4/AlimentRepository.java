package fr.adenlexar.v4;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

import fr.adenlexar.v4.modele.Aliment;

public class AlimentRepository {
    //se connecter à la référence "Aliments"
    public final FirebaseDatabase database = FirebaseDatabase.getInstance("https://tipe-collection-default-rtdb.firebaseio.com/");

    public final DatabaseReference myRef = database.getReference("Aliments");

    //créer une liste qui va contenir les aliments
    public ArrayList<Aliment> bdd;

    public void updateData () {
        myRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //retirer les anciens aliments
                bdd.clear();

                for (DataSnapshot i : dataSnapshot.getChildren()){
                    Aliment aliment = (Aliment) i.getValue(Aliment.class);

                    //vérifier que l'aliment n'est pas null
                    if (aliment != null){
                        bdd.add(aliment);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }

}
