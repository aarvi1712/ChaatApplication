package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class loggedIn extends AppCompatActivity {
EditText memail;
EditText mpassword;
String email;
String pass;
FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth= FirebaseAuth.getInstance();
        memail=findViewById(R.id.email);
        mpassword=findViewById(R.id.password);
    }

    public void login(View view) {

        email = memail.getText().toString().trim();
        pass = mpassword.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            memail.setError("email is required");
            return ;
        }
        if( TextUtils.isEmpty(pass))
        {
            mpassword.setError("password is required");
            return ;

        }
        if(pass.length()<6)
        {mpassword.setError("password length shorter than 6");
            return;
        }
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Log.d("tagline","succesfully logged in");
                  /*  ListRooms lroom=new ListRooms();
                    FirebaseUser user=auth.getCurrentUser();
                    lroom.EMail=user.getEmail();*/

                   Intent intent= new Intent(loggedIn.this,ListItems.class);
                   startActivity(intent);
                    Log.d("tagline","intented");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"login error occured",Toast.LENGTH_SHORT);
                }
            }
        });
    }

    public void go2Rester(View view) {
        startActivity(new Intent(loggedIn.this,MainActivity.class));
    }

}
