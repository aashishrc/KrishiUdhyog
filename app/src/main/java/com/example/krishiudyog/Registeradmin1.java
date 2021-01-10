package com.example.krishiudyog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Registeradmin1 extends AppCompatActivity {

    TextView tvregisteradmin,tvcreate,tvloginlink;
    EditText etname,etemail,etpass,etphone;
    Button btregister;
    FirebaseAuth fAuth;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeradmin1);

        tvregisteradmin=findViewById(R.id.tvregisteradmin);
        tvcreate=findViewById(R.id.tvcreate);
        tvloginlink=findViewById(R.id.tvloginlink);
        etname=findViewById(R.id.etname);
        etemail=findViewById(R.id.etemail);
        etpass=findViewById(R.id.etpassword);
        etphone=findViewById(R.id.etphone);
        btregister=findViewById(R.id.btregister);
        fAuth = FirebaseAuth.getInstance();
        pb=findViewById(R.id.pb);


        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),successfulpage.class));
            finish();
        }

        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=etname.getText().toString().trim();
                final String email1=etemail.getText().toString().trim();
                final String password1=etpass.getText().toString().trim();
                final String phone=etphone.getText().toString().trim();

                if(name.isEmpty())
                {
                    etname.setError("Please enter your name");
                    etname.requestFocus();
                    return;
                }

                if(email1.isEmpty())
                {
                    etemail.setError("Please enter your email");
                    etemail.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email1).matches())
                {
                    etemail.setError("Please enter valid email");
                    etemail.requestFocus();
                    return;
                }

                if(password1.isEmpty())
                {
                    etpass.setError("Please enter your password");
                    etpass.requestFocus();
                    return;
                }

                if(phone.isEmpty())
                {
                    etphone.setError("Please enter your phone number");
                    etphone.requestFocus();
                    return;
                }
                if(password1.length() < 6)
                {
                    etpass.setError("Password should be minimum of 6 literals");
                    etpass.requestFocus();
                    return;
                }

                pb.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            Admins admin= new Admins(name,email1,phone,password1);

                            FirebaseDatabase.getInstance().getReference("Admins")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(admin).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        pb.setVisibility(View.GONE);
                                        Toast.makeText(Registeradmin1.this, "User Created sucessfully", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Registeradmin1.this,com.example.krishiudyog.Adminlogin.class));
                                        Toast.makeText(getApplicationContext(),"Please Enter Login credentials to login",Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(Registeradmin1.this, "Error!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                        else
                        {
                            pb.setVisibility(View.GONE);
                            Toast.makeText(Registeradmin1.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        tvloginlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registeradmin1.this,com.example.krishiudyog.Adminlogin.class));
            }
        });


    }
}