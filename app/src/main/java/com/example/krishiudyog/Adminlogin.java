package com.example.krishiudyog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Adminlogin extends AppCompatActivity {

    TextView tvadminlogin,tvregisterlink;
    EditText etadminemail,etadminpassword;
    Button btadminlogin;
    ProgressBar adminpb;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        tvadminlogin=findViewById(R.id.tvadminlogin);
        tvregisterlink=findViewById(R.id.tvregisterlink);
        etadminemail=findViewById(R.id.etadminemail);
        etadminpassword=findViewById(R.id.etadminpassword);
        btadminlogin=findViewById(R.id.btadminlogin);
        adminpb=findViewById(R.id.adminpb);
        fAuth=FirebaseAuth.getInstance();

        tvregisterlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Adminlogin.this,com.example.krishiudyog.Registeradmin1.class));
            }
        });

        btadminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=etadminemail.getText().toString().trim();
                String password=etadminpassword.getText().toString().trim();

                if(email.isEmpty())
                {
                    etadminemail.setError("Please enter your email");
                    etadminemail.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    etadminemail.setError("Please enter valid email");
                    etadminemail.requestFocus();
                    return;
                }

                if(password.isEmpty())
                {
                    etadminpassword.setError("Please enter your password");
                    etadminpassword.requestFocus();
                    return;
                }

                if(password.length() < 6)
                {
                    etadminpassword.setError("Password should be minimum of 6 literals");
                    etadminpassword.requestFocus();
                    return;
                }

                adminpb.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(Adminlogin.this,com.example.krishiudyog.successfulpage.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Error logging in!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}