package com.example.krishiudyog;

import java.util.Vector;

public class Producers {

    public String fullname,email,phone,password,id;
    Products p;

    public Producers(){

    }

    public Producers(String fullname, String email, String phone,String password)
    {

        this.fullname=fullname;
        this.email=email;
        this.phone=phone;
        this.password=password;
    }


    public void setId(String id)
    {
        this.id=id;
    }
    public void addproduct(Vector<Products> v)
    {
        this.p=v.lastElement();
    }

    public String getFullname(
    ) {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
