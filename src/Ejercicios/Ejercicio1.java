/*
Negocio más barato
Emilia, se fue a vivir sola y ahora tiene que hacer los mandados ella sola (Antes los hacía siempre su mamá). No sabe bien dónde le 
conviene comprar cada producto, por ejemplo, las frutas y verduras, las puede comprar en el super, en el almacén, en el mercado del barrio, 
en la verdulería, algunas en la carnicería, en la dietética...

Te pide que le armes un sistema donde ella coloque "N” cantidad de negocios de los cuales relevó el precio de un producto y luego ingrese 
los precios del “Ni” negocio. Debes decirle en qué negocio le resulta más barato comprar el producto y el precio del mismo.

Entrada
Un valor entero N que indica la cantidad de negocios en los que Emilia recolectó el precio. Seguido de Ni precios recolectados

Salida
El número del negocio que posee el precio más barato, seguido de dicho precio.

ENTRADAS 
5
450
480
500
430
420

SALIDAS
5
420.0

ENTRADAS
3
230.50
229.80
230.90

SALIDAS
2
229,8
*/


package Ejercicios;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lee el número de negocios
        int N = scanner.nextInt();

        // Inicializa variables para almacenar el negocio más barato y su precio
        int negocioMasBarato = 0; // Inicialmente no se conoce el negocio más barato
        double precioMasBarato = Double.MAX_VALUE; // Inicializado con el valor máximo posible de un double

        // Recorre todos los negocios
        for (int i = 1; i <= N; i++) {
            double precioActual = scanner.nextDouble(); // Lee el precio del negocio actual

            // Compara el precio actual con el precio más barato conocido hasta ahora
            if (precioActual < precioMasBarato) {
                negocioMasBarato = i; // Actualiza el número del negocio más barato
                precioMasBarato = precioActual; // Actualiza el precio más bajo
            }
        }

        // Formatea el resultado en una cadena de texto
        String resultado = String.format(Locale.US, "%d %.2f", negocioMasBarato, precioMasBarato);

        System.out.println(resultado);

        scanner.close();
    }
}