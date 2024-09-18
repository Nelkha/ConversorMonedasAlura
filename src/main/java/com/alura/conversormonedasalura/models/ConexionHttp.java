/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.conversormonedasalura.models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nelkha
 */
public class ConexionHttp {
    private String direccion;
    private String sigla;

    public ConexionHttp(String direccion, String sigla) {
        this.direccion = direccion;
        this.sigla = sigla;
    }

 
    
   public String devolverRespuestaJson(){
        try {
            HttpClient client=HttpClient.newHttpClient();
            HttpRequest request=HttpRequest.newBuilder().uri(URI.create(this.direccion+this.sigla)).build();
            HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
            String json=response.body();
           
            return json;
        } catch (IOException ex) {
            Logger.getLogger(ConexionHttp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConexionHttp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ALGO FALLO";
   }
   
}
