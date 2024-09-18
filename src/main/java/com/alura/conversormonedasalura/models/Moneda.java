/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.conversormonedasalura.models;

import java.util.Map;

/**
 *
 * @author Nelkha
 */
public class Moneda {
    private String siglaBase;
    private String siglaDestino;
    Map<String,Double> conversiones;

    public Moneda(String siglaBase,String siglaDestino,MonedaOmdb monedaOmdb) {
        this.siglaBase = siglaBase;
        this.siglaDestino = siglaDestino;
        this.conversiones = monedaOmdb.conversion_rates();
    }


    public Map<String, Double> getConversiones() {
        return conversiones;
    }

 
    
    
    public double calcularConversion(double cantidadMoneda,double conversionRate){
    return cantidadMoneda*conversionRate;
    }

    @Override
    public String toString() {
        return "Moneda{" + "siglaBase=" + siglaBase + ", siglaDestino=" + siglaDestino + ", conversiones=" + conversiones + '}';
    }
    
    
    
}
