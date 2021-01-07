package com.example.krishiudyog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class Additem extends AppCompatActivity {
    EditText etname,etqty,etrate;
    Spinner qualityspinner;
    Button addbtn;

    DatabaseReference databaseproducts,dbproducer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        etname=findViewById(R.id.etname);
        etqty=findViewById(R.id.etqty);
        etrate=findViewById(R.id.etrate);
        addbtn=findViewById(R.id.addbtn);
        qualityspinner=findViewById(R.id.qualityspinner);
        databaseproducts= FirebaseDatabase.getInstance().getReference("Productsnews");


        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=etname.getText().toString().trim();
                String quality=qualityspinner.getSelectedItem().toString();
                String rate=etrate.getText().toString().trim();
                String quantity=etqty.getText().toString().trim();

                if(name.isEmpty())
                {
                    etname.setError("Please Enter the item name");
                    etname.requestFocus();
                    return;
                }
                if(rate.isEmpty())
                {
                    etrate.setError("Please Enter the cost of item");
                    etrate.requestFocus();
                    return;
                }
                if(quantity.isEmpty())
                {
                    etqty.setError("Please Enter the quantity");
                    etqty.requestFocus();
                    return;
                }

                String id=databaseproducts.push().getKey();

                String pid=getIntent().getStringExtra("producerid");
                String extra=" ";

                Productsnews product1=new Productsnews(rate,id,name,quality);


                databaseproducts.child(id).setValue(product1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Additem.this, "Product added successfully", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(Additem.this, "Error!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}
