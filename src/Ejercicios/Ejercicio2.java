/* 
Descripción
Emilia está muy asustada, porque no le gustan las matemáticas (ya te habrás dado cuenta de eso) y ya se acerca el fin del año escolar.
Necesita saber su promedio actual de los exámenes que tuvo durante el año para ver como va! Y también necesita que le indiques la nota 
mínima necesaria que debe sacarse en la única prueba que le falta hacer para aprobar la materia. Aprueba si tiene promedio mayor o igual 
a 6. Emilia quiere ingresar la cantidad de pruebas que ya hizo y luego una a una las notas que obtuvo en ellas. Y saber entonces su promedio
actual y la nota necesaria en el último examen para aprobar. Si un 10 en la prueba que falta no le alcanza para aprobar debes imprimirle el 
mensaje “Disculpa Emilia, deberás rendir la materia completa en Diciembre”.

Entrada
Un número entero N que indica la cantidad de examen ya realizados, seguido de Ni notas que obtuvo en ellos.

Salida
Dos valores reales que indican promedio actual y nota requerida en el último exámen para aprobar la materia. O el mensaje correspondiente 
cuando el promedio no llega a ser 6.

ENTRADA
5
5
4
3
5
7

SALIDA
4.80
Disculpa Emilia, deberas rendir la materia completa en Diciembre

ENTRADA
3
7
6
5

SALIDA
6.00
6.00

ENTRADA
4
4
5
6
7

SALIDA
5.50
8.00
*/

package Ejercicios;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Inicio el Scanner y creo la variable que va leer lo que ingreso por consola.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        
        // Creo 2 variables inicializandolas en cero.
        double sumaNotas = 0;
        int contadorExamenes = 0;
        
        /* 
        Creo un bucle for donde en cada iteracion ingreso una nota y esta nota se suma a una variable llamada "sumaNotas" y el
        "contadorExamenes" se incrementa en 1 en cada iteracion para llevar un registro del numero de examenes o notas ingresados
        */
        for (int i = 0; i < N; i++) {
            int nota = sc.nextInt();
            sumaNotas += nota;
            contadorExamenes++;
        }

        // Calculamos las notas ingresadas y la nota que falta para el proximo examen.
        double promedioActual = sumaNotas / contadorExamenes;
        double notaNecesaria = 6 * (N + 1) - sumaNotas;
        
        // Calcula el promedio actual y la nota necesaria para alcanzar un promedio de 6 o si tiene que rendir en diciembre. 
        if (notaNecesaria <= 10 && notaNecesaria >= 0) {
            System.out.printf("%.2f%n", promedioActual);
            System.out.printf("%.2f%n", notaNecesaria);
        } else {
            System.out.printf("%.2f%n", promedioActual);
            System.out.println("Disculpa Emilia, deberas rendir la materia completa en Diciembre");

            sc.close();
        }
    }
}