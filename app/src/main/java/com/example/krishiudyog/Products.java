package com.example.krishiudyog;

public class Products {

    String name,quality,quantity,rate,productid,producerid,category;
    Products(){

    }
    Products(/*String rate,String productid,*/String name,String quality,String quantity){
        this.name=name;
        this.quality=quality;
        this.quantity=quantity;

    }

    public String getProductid() {
        return productid;
    }

    public String getName() {
        return name;
    }

    public String getQuality() {
        return quality;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getRate() {
        return rate;
    }
}
