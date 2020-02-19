package com.example.chatapp;

 import androidx.annotation.NonNull;
 import androidx.annotation.Nullable;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.core.text.TextUtilsCompat;

 import android.content.Intent;
 import android.net.Uri;
 import android.os.Bundle;
 import android.os.Parcel;
 import android.text.TextUtils;
 import android.util.Log;
 import android.view.View;
import android.widget.Button;
import android.widget.EditText;
 import android.widget.Toast;

 import com.google.android.gms.internal.firebase_auth.zzff;
 import com.google.android.gms.tasks.OnCompleteListener;
 import com.google.firebase.FirebaseApp;
 import com.google.firebase.auth.AuthResult;
 import com.google.firebase.auth.FirebaseAuth;
 import com.google.firebase.auth.FirebaseUser;
 import com.google.android.gms.tasks.OnCompleteListener;
 import com.google.android.gms.tasks.Task;
 import com.google.firebase.auth.AuthResult;
 import com.google.firebase.auth.FirebaseAuth;
 import com.google.firebase.auth.FirebaseUserMetadata;
 import com.google.firebase.auth.UserInfo;
 import com.google.firebase.auth.zzy;
 import com.google.firebase.auth.zzz;

 import org.w3c.dom.Text;

 import java.util.List;

public class MainActivity<addonCo> extends AppCompatActivity {
    public FirebaseAuth auth;
    EditText memail;
    EditText mpassword;
    public String email;
    public String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       memail = findViewById(R.id.email);
        mpassword = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();


    }

    public void register(View view) {
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
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {

                   startActivity( new Intent(getApplicationContext(),loggedIn.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"some error in registering",Toast.LENGTH_SHORT);
                }
            }
        });

    }

    public void go2LoginPage(View view) {
        startActivity(new Intent(MainActivity.this,loggedIn.class));
    }
}
