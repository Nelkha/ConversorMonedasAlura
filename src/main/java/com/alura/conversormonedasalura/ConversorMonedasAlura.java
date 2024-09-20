/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.alura.conversormonedasalura;

import com.alura.conversormonedasalura.models.ConexionHttp;
import com.alura.conversormonedasalura.models.MonedaOmdb;
import com.alura.conversormonedasalura.models.Moneda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Scanner;

/**
 *
 * @author Nelkha
 */
public class ConversorMonedasAlura {

    public static void main(String[] args) {
        String apikey="Ingresar aqui su api";
        String siglaBase = "";
        String siglaDestino = "";
        final String direccion = "https://v6.exchangerate-api.com/v6/apikey/latest/";
        double cantConversion;
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 7) {
            String menu = """
                                          ------------------
                                          Seleccione la conversion de su interes
                                          1.Dolar a pesos argentinos
                                          2.Pesos argentinos a Dolar
                                          3.Real a Dolar
                                          4.Dolar a Real
                                          5.Dolar a peso Colombiano
                                          6.Peso Colombiano a Dolar
                                          7.Salir
                                          """;
            System.out.println(menu);
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el importe en USD a convertir");
                    cantConversion = scanner.nextInt();
                    siglaBase = "USD";
                    siglaDestino = "ARS";
                    procesarConversion(siglaBase, siglaDestino, direccion, cantConversion);
                    break;
                case 2:
                    System.out.println("Ingrese el importe en ARS a convertir");
                    cantConversion = scanner.nextInt();
                    siglaBase = "ARS";
                    siglaDestino = "USD";
                    procesarConversion(siglaBase, siglaDestino, direccion, cantConversion);
                    break;
                case 3:
                    System.out.println("Ingrese el importe en BRL a convertir");
                    cantConversion = scanner.nextInt();
                    siglaBase = "BRL";
                    siglaDestino = "USD";
                    procesarConversion(siglaBase, siglaDestino, direccion, cantConversion);
                    break;
                case 4:
                    System.out.println("Ingrese el importe en USD a convertir");
                    cantConversion = scanner.nextInt();
                    siglaBase = "USD";
                    siglaDestino = "BRL";
                    procesarConversion(siglaBase, siglaDestino, direccion, cantConversion);
                    break;
                case 5:
                    System.out.println("Ingrese el importe en USD a convertir");
                    cantConversion = scanner.nextInt();
                    siglaBase = "USD";
                    siglaDestino = "COP";
                    procesarConversion(siglaBase, siglaDestino, direccion, cantConversion);
                    break;
                case 6:
                    System.out.println("Ingrese el importe en COP a convertir");
                    cantConversion = scanner.nextInt();
                    siglaBase = "COP";
                    siglaDestino = "USD";
                    procesarConversion(siglaBase, siglaDestino, direccion, cantConversion);
                    break;
                case 7:
                    System.out.println("Gracias por usar este servicio, hasta pronto");
                    break;
                default:
                    System.out.println("Opcion invalida,seleccion una de las opciones del menu");
            }

        }

    }

    public static void procesarConversion(String siglaBase, String siglaDestino, String direccion, double cantConversion) {
        ConexionHttp conexion = new ConexionHttp(direccion, siglaBase);
        MonedaOmdb monedaOmdb = crearMonedaOmdb(conexion.devolverRespuestaJson());
        Moneda moneda = new Moneda(siglaBase, siglaDestino, monedaOmdb);
        System.out.println(cantConversion+ " "+ siglaBase + " equivale a " + +moneda.calcularConversion(cantConversion, moneda.getConversiones().get(siglaDestino)) +" "+ siglaDestino);
    }

    public static MonedaOmdb crearMonedaOmdb(String json) {

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
        MonedaOmdb monedaOmdb = gson.fromJson(json, MonedaOmdb.class);

        return monedaOmdb;
    }
}
