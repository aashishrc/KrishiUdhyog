package com.example.krishiudyog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ConsumerSearchItem extends AppCompatActivity {

    Spinner itemspinner;
    ImageButton btsearch;
    RecyclerView conrv;
    Conitemadapter conadapter;
    List<Itemslist> conitemslist;
    DatabaseReference dbitems;
    TextView ProducerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_search_item);

        itemspinner = findViewById(R.id.itemspinner);
        btsearch = findViewById(R.id.btsearch);
        conitemslist = new ArrayList<>();
        conrv = findViewById(R.id.conrv);
        conrv.setHasFixedSize(true);
        conrv.setLayoutManager(new LinearLayoutManager(this));
        conadapter = new Conitemadapter(this, conitemslist);
        conrv.setAdapter(conadapter);
        ProducerName=findViewById(R.id.ProducerName);


        dbitems = FirebaseDatabase.getInstance().getReference("Itemslist");
        final Query query = FirebaseDatabase.getInstance().getReference("Itemslist");

        btsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemname = itemspinner.getSelectedItem().toString();

                query.orderByChild("productname").equalTo(itemname).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        conitemslist.clear();
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                Itemslist item = snapshot.getValue(Itemslist.class);
                                conitemslist.add(item);
                                /*Display_item di=new Display_item();
                                di.getdata(item.getProductname(),item.getPname(),item.getQuantity(),item.getContact(),item.getRate(),item.getLocation(),item.getQuality());
                                intent.putExtra("productname",item.getProductname());
                                intent.putExtra("producername",item.getPname());
                                intent.putExtra("availablequantity",item.getQuantity());
                                intent.putExtra("price",item.getRate());
                                intent.putExtra("contactno",item.getContact());
                                intent.putExtra("location",item.getLocation());
                                intent.putExtra("image",item.getImage());
                                intent.putExtra("quality",item.getQuality());*/

                                //Toast.makeText(ConsumerSearchItem.this,"searching "+item.getPname(),Toast.LENGTH_SHORT).show();

                                /*conadapter.setOnClickListener(new Conitemadapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(int position) {
                                        Intent intent=new Intent(ConsumerSearchItem.this,com.example.krishiudyog.Display_item.class);
                                        startActivity(intent);
                                        //conitemslist.get(position);
                                    }
                                });*/
                            }
                            conadapter.notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(ConsumerSearchItem.this,"Sorry, Item Not Available",Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

    }


}

/*searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                if(list.contains(query)){

                    adapter.getFilter().filter(query);
                    Intent intent = new Intent(ConsumerSearchItem.this,ConsumerViewItem.class);
                    startActivity(intent);


                }else{
                    Toast.makeText(ConsumerSearchItem.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });*/