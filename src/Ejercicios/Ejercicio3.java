/*
Hoy en día, en Argentina, hay muchas promociones para pagar con tarjetas de crédito (Banco Santa Fe, Banco Nación, otros) o medios de pago 
electrónicos (Modo, Billetera Santa Fe, …). Y ocurre que los productos nos quedan mucho más baratos si aplicamos las promos comparado con 
abonar en efectivo.

El Banco Santa Fe, una semana al mes, larga lo que él llama “Buena Semana” que propone para la compra de Indumentaria, calzado, 
marroquinería y juguetería 25% para la cartera general (tarjetas de crédito Internacional o Gold) y 40% para la cartera Premiun (Black, 
Signature o Platinum).

El reintegro tiene un tope de $4.000 por transacción para la cartera general y un tope de $6.000 por transacción para la cartera premium. 
O sea, que si el comercio es buena onda y “divide” el pago en muchas transacciones, se puede lograr sortear ese límite. También ofrece la 
posibilidad de abonar con modo, con un reintegro del 20% con tope de 2.000 mensual. Tener en cuenta que dicho limite, una vez alcanzado 
los 2.000 por única vez durante la vigencia de la promo.

A su vez, la promo permite abonar en un pago o en 3 cuotas. En caso de decidir abonar en 3 cuotas, el reintegro se realiza íntegramente 
en el primer resumen.

Emilia, que está un poco mareada con tantos datos, te pide que le hagas un programita donde ella coloca “N” compras a realizar durante 
esa “Buena Semana” y luego los siguientes datos para cada compra:

-Precio del producto a comprar.
-Cartera que posee (G para General o P para Premium).
-Si el comercio es Buena Onda o no (B para Buena onda, M para Mala onda).

Y quiere como salida para cada compra:
-Si el comercio es buena onda, se debe imprimir en cuantas transacciones se debe dividir el pago.
-Reintegro total alcanzado.
-Monto de cuanto le terminó saliendo el producto.

Entrada
La primera línea de entrada contendrá el valor N, indicando las N compras. Luego por cada compra se ingresan los siguientes datos, uno por 
línea:

-G para cartera General o P para cartera Premium
-B para negocio Buena Onda o M para negocio Mala Onda
-T para tarjeta o M para Modo
-1 o 3 indicando las cuotas seleccionadas

Salida
Si el comercio es buena onda, se debe imprimir en cuantas transacciones se debe dividir el pago. Para todos los pagos se debe imprimir 
reintegro total alcanzado y monto de cuanto le terminó saliendo el producto.

EJEMPLO 1: 
ENTRADA 
3
1000
P
B
T
1
10000
P
M
M
1
16000
P
B
M
1

SALIDA 
400.00
600.00
4000.00
6000.00
2
6400.00
9600.00

EJEMPLO 2:
ENTRADA
1
100000
P
B
M
3

SALIDA
7
42000
58000

EJEMPLO 3:
ENTRADA
1
100000
G
B
M
3

SALIDA 
10
27000
73000
*/

package Ejercicios;
import java.util.Scanner;

public class Ejercicio3 {  
  public static void main (String[] args){
    Scanner entrada = new Scanner(System.in);
    
    int N;
    int cuotas;
    double precio;
    int transacciones;
    char cartera;
    char onda;
    char metodo;
    double precioFinal; 
    double descuento = 0;
    int montoModo = 2000;
    
    final char malaOnda = 'M';
    final char carteraPremium = 'P';
    final char metodoModo = 'M';
    final int montoParaTopePremium = 15000;
    final int montoParaTopeGeneral = 16000;
    
    // Pedimos el nro de compras a realizar
    N = entrada.nextInt();
    
    for (int i = 0; i < N; i++) {
      precio = entrada.nextInt();
      cartera = entrada.next().charAt(0);
      onda = entrada.next().charAt(0);
      metodo = entrada.next().charAt(0);
      cuotas = entrada.nextInt();
      
      if (metodo == metodoModo) { // Aplica MODO o no
        if (precio >= 10000) { // == precio * 0.2 > 2000 (que es el tope de MODO) 
          descuento += montoModo; // Sumo el tope de 2000
          montoModo -= 2000; // Dejo el monto disponible de MODO en 0
        } else {
          descuento += Math.max(montoModo - (precio * 0.2), 0); // Saco el 20% de la compra y se lo resto a lo que haya disponible de MODO, si es menor a 0, dejo el valor del descuento en 0
          montoModo -= Math.max(montoModo - (precio * 0.2), 0);
        }
      }
      
      if (onda == malaOnda) {
        if (cartera == carteraPremium) {
          if (precio >= montoParaTopePremium) { // 15000 es el monto mínimo para obtener descuento tope 
            descuento = descuento + 6000; // 6000 es el tope de descuento
            precioFinal = precio - descuento;
            System.out.println(String.format("%.2f", descuento));
            System.out.println(String.format("%.2f", precioFinal));
          } else {
            descuento = descuento + (precio * 0.4);
            precioFinal = precio - descuento;
            System.out.println(String.format("%.2f", descuento));
            System.out.println(String.format("%.2f", precioFinal));
          }
        } else { // General (G) y Mala Onda (M)
          if (precio >= montoParaTopeGeneral) { // 16000 es el monto mínimo para obtener descuento tope
            descuento = descuento + 4000; // 4000 es el tope de descuento
            precioFinal = precio - descuento;
            System.out.println(String.format("%.2f", descuento));
            System.out.println(String.format("%.2f", precioFinal));
          } else {
            descuento = descuento + (precio * 0.25);
            precioFinal = precio - descuento;
            System.out.println(String.format("%.2f", descuento));
            System.out.println(String.format("%.2f", precioFinal));
          }
        }
      } else { // Buena Onda (B)
        if (cartera == carteraPremium) { // Premium (P) y Buena Onda (B)
          if (precio > montoParaTopePremium) {
            transacciones = (int) (precio / montoParaTopePremium) + 1;
            descuento += (precio * 0.4);
            precioFinal = precio - descuento;
            System.out.println(transacciones);
            System.out.println(String.format("%.2f", descuento));
            System.out.println(String.format("%.2f", precioFinal));
          } else {
            descuento = descuento + (precio * 0.4);
            precioFinal = precio - descuento;
            transacciones = 1;
            System.out.println(transacciones);
            System.out.println(String.format("%.2f", descuento));
            System.out.println(String.format("%.2f", precioFinal));
          }
        } else { // General (G) y Buena Onda (B)
          if (precio > montoParaTopeGeneral) {
            transacciones = (int) (precio / montoParaTopeGeneral) + 1;
            descuento = descuento + (25 * precio) / 100;
            precioFinal = precio - descuento;
            System.out.println(transacciones);
            System.out.println(String.format("%.2f", descuento));
            System.out.println(String.format("%.2f", precioFinal));
          } else {
            descuento = descuento + (25 * precio) / 100;
            precioFinal = precio - descuento;
            transacciones = 1;
            System.out.println(transacciones);
            System.out.println(String.format("%.2f", descuento));
            System.out.println(String.format("%.2f", precioFinal));
          }
        }
      }       
      descuento = 0; // El descuento debe volver a cero para calcularse en la siguiente iteración del loop
    }
  }
}
