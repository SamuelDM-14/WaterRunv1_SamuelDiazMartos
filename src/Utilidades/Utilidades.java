/**
 * Utilidades
 * @author SDM
 * @version 1.6
 * 07-03-2025
 */
package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import excepciones.CaracterIncorrectoException;
import excepciones.MasCaracteresPermitidosException;
import excepciones.NumeroFueraDeRangoException;
import log.Log;

/**
 * Archivo Utilidades que usaremos para metodos de validación
 */
public class Utilidades {

    // Usamos BufferedReader para leer. Creación del objeto.
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Lee un único caracter desde teclado ('S' o 'N'), validando que no sea otro.
     * 
     * @return 'S' o 'N' en mayúscula
     * @throws IOException
     */
    public static char leerSN() {
        boolean valido = false;
        char c = ' '; // variable donde guardaremos la elección
        try {
            do { // Repite hasta que escribas el caracter correcto.

                String caracter = bf.readLine(); // Guarda la respuesta en un string.
                try {
                    if (caracter.length() == 1) { // Comprueba que el string sea de 1 caracter.
                        c = caracter.charAt(0); // combierte el string en caracter y lo guarda en re1
                        c = Character.toUpperCase(c); // pasa el re1 a mayusculas y lo guarda de nuevo en re1

                        if (c == 'S' || c == 'N') {
                            valido = true;
                        } else {
                            System.out.println("No has escrito ninguna de las 2 opciones. Prueba otra vez.");
                            throw new CaracterIncorrectoException("No has escrito ninguna de las 2 opciones.");
                        }
                    } else {
                        System.out.println("No has escrito un único caracter. Prueba otra vez.");
                        throw new MasCaracteresPermitidosException("No has escrito un único caracter");
                    }
                } catch (CaracterIncorrectoException CIe) {
                    Log.guardarError(CIe, CIe.getMessage());
                } catch (MasCaracteresPermitidosException MCPe) {
                    Log.guardarError(MCPe, MCPe.getMessage());
                }
            } while (!valido);
        } catch (IOException IOe) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(IOe, IOe.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }

        return c;
    }

    /**
     * Metodo que se encarga de leer una cadena y valida que sea 'S' o 'N' la
     * respuesta.
     * 
     * @return Devuelve un String con el caracter 'S' o 'N'
     */
    public static String leerSNCadena() {
        boolean valido = false;
        String caracter = " "; // variable donde guardaremos la elección
        try {
            do { // Repite hasta que escribas el caracter correcto.

                caracter = bf.readLine(); // Guarda la respuesta en un string.
                caracter = caracter.toUpperCase();
                if (caracter.length() == 1) { // Comprueba que el string sea de 1 caracter.

                    if (caracter.equalsIgnoreCase("s") || caracter.equalsIgnoreCase("n")) {
                        valido = true;
                    } else {
                        System.out.println("No has escrito ninguna de las 2 opciones. Prueba otra vez.");
                    }
                } else {
                    System.out.println("No has escrito un único caracter. Prueba otra vez.");
                }
            } while (!valido);
        } catch (IOException IOe) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(IOe, IOe.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }

        return caracter;
    }

    /**
     * Metodo que se encarga de leer una cadena.
     * 
     * @return Devuelve la cadena leida.
     */
    public static String leerCadena() {
        String cadena = "";
        try {
            cadena = bf.readLine();
        } catch (IOException IOe) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(IOe, IOe.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }
        return cadena;
    }

    /**
     * Lee un número entero, validando que esté entre min y max.
     * Si el usuario escribe algo inválido (caracteres no numéricos o número fuera
     * de rango), el método vuelve a pedirlo.
     * 
     * @return el número entero válido que el usuario introduzca
     */
    public static int leerEnteroValidado() {
        boolean valido = false;
        int valor = 0; // variable para guardar la lectura
        while (!valido) {
            try {
                String linea = bf.readLine(); // leer texto
                valor = Integer.parseInt(linea); // convertir a int
                if (valor >= VarGenYConst.min && valor <= VarGenYConst.max) {
                    valido = true; // se cumple la condición → marcamos como válido
                } else {
                    throw new NumeroFueraDeRangoException("No escribio un número dentro del rango entre "
                            + VarGenYConst.min + " y " + VarGenYConst.max + ".");
                }
            } catch (NumeroFueraDeRangoException NFDRe) {
                System.out.println("Debes escribir un número entre " + VarGenYConst.min + " y " + VarGenYConst.max
                        + ". Inténtalo de nuevo.");
                Log.guardarError(NFDRe, NFDRe.getMessage());
            } catch (NumberFormatException NFe) {
                System.out.println("No has escrito un número válido. Inténtalo de nuevo.");
                Log.guardarError(NFe, NFe.getMessage());
            } catch (IOException IOe) {
                System.out.println("Ha ocurrido un error.");
                Log.guardarError(IOe, IOe.getMessage());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error.");
                Log.guardarError(e, e.getMessage());
            }
        }
        // Cuando salgamos del while, 'valido == true', y 'valor' está en rango
        return valor;
    }

}
