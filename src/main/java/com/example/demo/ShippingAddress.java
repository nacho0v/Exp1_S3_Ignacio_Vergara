package com.example.demo;

public class ShippingAddress {
    private String idDireccion;
    private String region;
    private String comuna;
    private String calle;
    private String numero;

    public ShippingAddress(String idDireccion, String region, String comuna, String calle, String numero){

        this.idDireccion= idDireccion;
        this.region= region;
        this.comuna= comuna;
        this.calle= calle;
        this.numero= numero;
    }

    public String getIdDireccion(){
        return idDireccion;
    }
    public String getRegion(){
        return region;
    }
    public String getComuna(){
        return comuna;
    }
    public String getCalle(){
        return calle;
    }
    public String getNumero(){
        return numero;
    }
    
}
