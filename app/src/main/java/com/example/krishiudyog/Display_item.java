package com.example.krishiudyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Display_item extends AppCompatActivity {

    ImageView display_image,ivdisplay,ivdisplaycall,displaylocation;
    TextView displayname,displayqty,tv_qty,displayprice,displaypname,tvmobile,tvrules,tvplace,displayquality;
    Button placeorder;
    ElegantNumberButton eqty;

    String itemname;
    String producername;
    String quantity;
    String contactno;
    String price;
    String location;
    String quality;
    public Display_item(){}

    DatabaseReference fitemsref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);

        display_image=findViewById(R.id.display_image);
        ivdisplay=findViewById(R.id.ivdisplay);
        ivdisplaycall=findViewById(R.id.ivdisplaycall);
        displaylocation=findViewById(R.id.displaylocation);
        displayname=findViewById(R.id.displayname);
        displayqty=findViewById(R.id.displayqty);
        tv_qty=findViewById(R.id.tv_qty);
        displayprice=findViewById(R.id.displayprice);
        displaypname=findViewById(R.id.displaypname);
        tvmobile=findViewById(R.id.tvmobile);
        tvplace=findViewById(R.id.tvplace);
        displayquality=findViewById(R.id.displayquality);
        placeorder=findViewById(R.id.placeorder);
        fitemsref=FirebaseDatabase.getInstance().getReference("Itemslist");
        assigndata();

    }

    public void assigndata(){

        HashMap<String,Integer> hashMap=new HashMap<String, Integer>();

        hashMap.put("ONION",R.mipmap.bigonion);
        hashMap.put("POTATO",R.mipmap.bigpotato);
        hashMap.put("CABBAGE",R.mipmap.bigcabbage);
        hashMap.put("RICE",R.mipmap.bigrice);
        hashMap.put("WHEAT",R.mipmap.bigwheat);
        hashMap.put("CAULIFLOWER",R.mipmap.bigcauliflower);
        hashMap.put("BRINJAL",R.mipmap.bigbrinjal);
        hashMap.put("CARROT",R.mipmap.bigcarrot);
        hashMap.put("RADISH",R.mipmap.bigradish);
        hashMap.put("GREEN BEANS",R.mipmap.biggreenbeans);
        hashMap.put("CAPSICUM",R.mipmap.bigcapsicum);

        displayname.setText(getIntent().getStringExtra("productname"));
        displaypname.setText(getIntent().getStringExtra("producername"));
        tvplace.setText(getIntent().getStringExtra("location"));
        tvmobile.setText(getIntent().getStringExtra("contactno"));
        displayqty.setText(getIntent().getStringExtra("availablequantity"));
        displayprice.setText(getIntent().getStringExtra("price"));
        displayquality.setText(getIntent().getStringExtra("quality"));

        display_image.setImageDrawable(getApplicationContext().getResources().getDrawable(hashMap.get(getIntent().getStringExtra("productname"))));
    }

    public void getdata(String name,String pname,String quantity,String contactno,String price,String location,String quality){

        this.itemname=name;
        this.producername=pname;
        this.quantity=quantity;
        this.contactno=contactno;
        this.price=price;
        this.location=location;
        this.quality=quality;

    }
}