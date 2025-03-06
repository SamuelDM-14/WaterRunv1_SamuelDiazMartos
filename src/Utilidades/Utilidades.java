package Utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilidades {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));    
    /**
    * Lee un único caracter desde teclado ('S' o 'N'), validando que no sea otro.
    * @param bf BufferedReader para leer de teclado
    * @return 'S' o 'N' en mayúscula
    * @throws IOException
    */
    public static char leerSN() throws IOException {
        boolean valido = false;
        char c = ' '; // variable donde guardaremos la elección
        do { //Repite hasta que escribas el caracter correcto.
    
            String caracter = bf.readLine(); //Guarda la respuesta en un string.

            if (caracter.length()==1) { //Comprueba que el string sea de 1 caracter.
                c = caracter.charAt(0); //combierte el string en caracter y lo guarda en re1
                c = Character.toUpperCase(c); //pasa el re1 a mayusculas y lo guarda de nuevo en re1
                if (c == 'S' || c == 'N'){
                    valido = true;
                } else {
                    System.out.println("No has escrito ninguna de las 2 opciones. Prueba otra vez.");
                }
            } else {
                System.out.println("No has escrito un único caracter. Prueba otra vez.");
            }
        } while (!valido);

        return c;
    }

    /**
     * Lee un número entero, validando que esté entre min y max.
     * Si el usuario escribe algo inválido (caracteres no numéricos o número fuera de rango),
     * el método vuelve a pedirlo.
     *
     * @param bf  el BufferedReader para leer la entrada
     * @param min límite inferior aceptado (inclusive)
     * @param max límite superior aceptado (inclusive)
     * @return el número entero válido que el usuario introduzca
     ****/
    public static int leerEnteroValidado(int min, int max) throws IOException {
        boolean valido = false;
        int valor = 0; // variable para guardar la lectura
        while (!valido) {
            try {
                String linea = bf.readLine(); // leer texto
                valor = Integer.parseInt(linea); // convertir a int
                if (valor >= min && valor <= max) {
                    valido = true;  // se cumple la condición → marcamos como válido
                } else {
                    System.out.println("Error: Debes escribir un número entre " + min + " y " + max + ". Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: No has escrito un número válido. Inténtalo de nuevo.");
            }
        }
        // Cuando salgamos del while, 'valido == true', y 'valor' está en rango
        return valor;
    }



}
