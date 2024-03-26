package com.example.demo;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private List<Rol> roles;
    private List<ShippingAddress> shippingAddress;

    public User(int id, String name, String email, String password, List<Rol> roles, List<ShippingAddress> shippingAddress){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.roles = roles;
        this.shippingAddress = shippingAddress;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public List<ShippingAddress> getShippingAddress() {
        return shippingAddress;
    }
}
