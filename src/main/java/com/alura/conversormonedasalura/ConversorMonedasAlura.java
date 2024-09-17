/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.alura.conversormonedasalura;

import java.util.Scanner;

/**
 *
 * @author Nelkha
 */
public class ConversorMonedasAlura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 9) {
            String menu = """
                   ------------------
                   Seleccione la conversion de su interes
                   1.Pesos a dolares
                   2.
                   3.
                   4.
                   """;
            System.out.println(menu);
            opcion = scanner.nextInt();

        }
    }
}
