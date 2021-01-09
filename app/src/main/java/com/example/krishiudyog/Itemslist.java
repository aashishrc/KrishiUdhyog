package com.example.krishiudyog;

public class Itemslist {

    String quality,quantity,rate,pname,location,contact;

    public Itemslist(){}

    public Itemslist(String quality, String quantity, String rate, String pname, String location,String contact) {
        this.pname = pname;
        this.location = location;
        this.contact=contact;
        this.quality = quality;
        this.quantity = quantity;
        this.rate = rate;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public String getPname() {
        return pname;
    }

    public String getLocation() {
        return location;
    }
}
