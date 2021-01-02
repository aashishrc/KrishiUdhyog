package com.example.krishiudyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView adminbut,custombut,producebut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv=findViewById(R.id.tvtitle);

        adminbut=findViewById(R.id.adminbut);
        custombut=findViewById(R.id.custombut);
        producebut=findViewById(R.id.producebut);

        adminbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.example.krishiudyog.ui.login.adminlogin.class);
                startActivity(intent);
            }
        });

        custombut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.example.krishiudyog.ui.login.customlogin.class);
                startActivity(intent);
            }
        });

        producebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.example.krishiudyog.ui.login.producelogin.class);
                startActivity(intent);
            }
        });



    }

}