package com.aluracursos.conversordivisas.principal;

import com.aluracursos.conversordivisas.modelos.Divisa;
import com.aluracursos.conversordivisas.modelos.HTTPRequest;
import com.aluracursos.conversordivisas.modelos.RegistroDivisas;
import com.aluracursos.conversordivisas.calculos.Calculos;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String salida = null;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido al conversor de divisas");

        while (salida != "salir") {
            try {
                System.out.println("""
                        Digita la divisa de origen con su denominación de 3 letras(USD, MXN, CLP, BRL)
                        O escriba 'salir' para terminar.
                        
                        """);

                String divisaUno = teclado.nextLine().toUpperCase().replace(" ", "+");
                if (divisaUno.equalsIgnoreCase("salir")) {
                    break;
                }

                System.out.println("Ahora ingrese la cantidad a convertir:");
                Double cantidad = Double.valueOf(teclado.nextLine());
                System.out.println("¿Cuál es la divisa de conversión?");
                String divisaDos = teclado.nextLine().toUpperCase().replace(" ", "+");
                HTTPRequest requerimiento = new HTTPRequest();
                Divisa divisa = requerimiento.busqueda(divisaUno);
                RegistroDivisas divisas = new RegistroDivisas(divisa);
                Calculos conversion = new Calculos();
                double totalConversion = conversion.calculaConversion(divisaUno, divisaDos, cantidad, divisas);
                System.out.println("El valor de: " + cantidad + " " + divisaUno + " es de: " + totalConversion + " " + divisaDos);

            } catch (Exception e) {
                System.out.println("La divisa ingresada no existe: " + e.getMessage());
            }

        }
        System.out.println("Termino la conversión");
        //System.out.println(divisa.conversion_rates());

    }
}
