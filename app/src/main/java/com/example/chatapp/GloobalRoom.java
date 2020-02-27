package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GloobalRoom extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    EditText txt;
    Button btn;
    String key;
    String chatname = "IA";
    String username = "pto";
    RecyclerView rcview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gloobal_room);
        rcview = findViewById(R.id.recyclerView);
        rcview.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        txt=findViewById(R.id.editText1);
        btn=findViewById(R.id.enter);

        final List<ChatDetails> msglist=new ArrayList<>();
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference("chatapp/IA/");



   btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(txt.getText().toString()!="") {
    key = myRef.push().getKey();
  /*  Map<String,String> map=new HashMap<String, String>();
    map.put("message",txt.getText().toString());
    map.put("user",username);*/
 myRef.child(key).child("message").setValue(txt.getText().toString());
   myRef.child(key).child("user").setValue(username);
//  myRef.child(key).setValue(map);
    txt.setText("");
            }
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               // String str="";
               // msglist.clear();
                for (DataSnapshot uniqueKeySnapshot : dataSnapshot.getChildren()) {
                  //  str = str + "\n\n" +uniqueKeySnapshot.child("message").getValue().toString();
                   // ChatDetails chat=new ChatDetails(uniqueKeySnapshot.child("message").getValue().toString(),uniqueKeySnapshot.child("user").getValue().toString());
                String msgg=uniqueKeySnapshot.child("message").getValue().toString();
                String username=uniqueKeySnapshot.child("user").getValue().toString();
                ChatDetails chat=new ChatDetails(username,msgg);
                    msglist.add(chat);


                  //  txtview.setText(str);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        MessageAdapter msgadapter=new MessageAdapter(this,msglist);
        rcview.setAdapter(msgadapter);







    }
    }
