package com.example.krishiudyog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Itemadapter extends RecyclerView.Adapter<Itemadapter.Itemviewholder> {

    private Context cntxt;
    private List<Itemslist> itemslist;

    public Itemadapter(Context cntxt, List<Itemslist> itemslist) {
        this.cntxt = cntxt;
        this.itemslist = itemslist;
    }

    @NonNull
    @Override
    public Itemviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(cntxt);
        View view=inflater.inflate(R.layout.itemlist,null);
        return new Itemviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Itemviewholder holder, int position) {

        Itemslist item=itemslist.get(position);
        holder.Producername.setText(item.getPname());
        holder.tvlocation.setText(item.getLocation());
        holder.tvgrade.setText(item.getQuality());
        holder.tvquantity.setText(item.getQuantity());
        holder.Price.setText(item.getRate());

    }

    @Override
    public int getItemCount() {
        return itemslist.size();
    }

    public class Itemviewholder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvgrade,tvquantity,Producername,Price,tvlocation;

        public Itemviewholder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            tvgrade=itemView.findViewById(R.id.tvgrade);
            tvlocation=itemView.findViewById(R.id.tvpname);
            tvquantity=itemView.findViewById(R.id.tvquantity);
            Producername=itemView.findViewById(R.id.Producername);
            Price=itemView.findViewById(R.id.Price);

        }
    }
}
