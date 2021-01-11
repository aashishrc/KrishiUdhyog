package com.example.krishiudyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

public class ProducersHomePage extends AppCompatActivity {

    TextView tvwelcome,tvadditem,tvorders,tvnotifications,tvcustomers,tvvitems;
    ImageView notifications,additem,orders,customers,viewitems;
    Button btlogout;
    ImageButton schemes;

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
        viewitems=findViewById(R.id.viewitems);
        tvvitems=findViewById(R.id.tvvitems);
        schemes=findViewById(R.id.schemes);

        final String Producerid=getIntent().getStringExtra("producerid");

        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProducersHomePage.this,com.example.krishiudyog.Additem.class);
                intent.putExtra("producerid",Producerid);
                startActivity(intent);
            }
        });

        viewitems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProducersHomePage.this,com.example.krishiudyog.ViewItems.class));
            }
        });

        btlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),com.example.krishiudyog.ProducerLogin.class));
            }
        });

        schemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://agricoop.gov.in/programmes-schemes-listing"));
                startActivity(intent);
            }
        });



    }
}