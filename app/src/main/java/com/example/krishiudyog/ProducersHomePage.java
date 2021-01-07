package com.example.krishiudyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProducersHomePage extends AppCompatActivity {

    TextView tvwelcome,tvadditem,tvorders,tvnotifications,tvcustomers;
    ImageView notifications,additem,orders,customers;
    Button btlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producers_home_page);

        tvwelcome=findViewById(R.id.tvwelcome);
        tvadditem=findViewById(R.id.tvadditem);
        tvorders=findViewById(R.id.tvorders);
        tvnotifications=findViewById(R.id.tvnotifications);
        tvcustomers=findViewById(R.id.tvcustomers);
        notifications=findViewById(R.id.notifications);
        additem=findViewById(R.id.additem);
        orders=findViewById(R.id.orders);
        customers=findViewById(R.id.customers);
        btlogout=findViewById(R.id.btlogout);


        final String Producerid=getIntent().getStringExtra("producerid");

        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProducersHomePage.this,com.example.krishiudyog.Additem.class);
                intent.putExtra("producerid",Producerid);
                startActivity(intent);
            }
        });

        btlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),com.example.krishiudyog.ProducerLogin.class));
            }
        });

    }
}