package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class GloobalRoom extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gloobal_room);
//txt=findViewById(R.id.txtview);
    database = FirebaseDatabase.getInstance();
       myRef = database.getReference("hari") ;


   //  Map<String,Object> upvalue= new HashMap<>();
   //  upvalue.put("-M0TeEhazmGQqL3a8x0n/sohan","garba dandiya thaaayoo");
    //    myRef.updateChildren(upvalue);

       /*   myRef.push().child("sohan").setValue("Hello, ");
        myRef.push().child("mohan").setValue("Hello, !");
        myRef.push().child("rohan").setValue("Hello,!");
  /*   myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              //  String str=dataSnapshot.getValue(String.class);
                Map<String,Object> data=(Map<String,Object>)dataSnapshot.getValue();
                txt.setText(data.get("rohan")+" "+data.get("mohan"));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

    }
}
