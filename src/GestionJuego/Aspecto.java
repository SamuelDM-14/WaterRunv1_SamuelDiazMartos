/**
 * Aspecto
 * @author SDM
 * 14-03-2025
 */
package gestionjuego;

import java.io.IOException;

import utilidades.Utilidades;

public class Aspecto {
        //Variable para mostrar el menú adecuado. En cada metodo cambia.
        private static int opcionMenu=0;

        //Variables utilizadas para leer números enteros y validar las respuestas.
        private static int max = 5;
        private static int min = 0;

        // Deja el color como al principio.
        private static final String COLOR_RESET = "\u001B[0m";

        //Colores para los personajes.

        private static final String[] COLORESPJ = {
            "\u001B[31m",//0=Rojo
            "\u001B[32m",//1=Verde
            "\u001B[33m",//2=Amarillo
            "\u001B[34m",//3=Azul
            "\u001B[35m",//4=Morado
            "\u001B[36m",//5=Cyan
            "\u001B[37m",//6=Blanco
            "\u001B[30m"// 7=Negro
        };
            
        //Colores del fondo.

        private static final String[] COLORESPOLICIA= {
            "\u001B[41m",//0=Rojo
            "\u001B[42m",//1=Verde
            "\u001B[43m",//2=Amarillo
            "\u001B[44m",//3=Azul
            "\u001B[45m",//4=Morado
            "\u001B[46m",//5=Cyan
            "\u001B[47m",//6=Blanco
            "\u001B[40m",//7=NEGRO
        };

    /**
     * Gestiona la eleccion de los colores del Escapista comprobando que no estes eligiendo el mismo color que el Policia
     * @param eleccionColor
     */
    private static void gestorColorPj(int eleccionColor, String colorPj, String colorPo){
        eleccionColor=eleccionColor-1;
        if (colorPj==COLORESPOLICIA[eleccionColor]) {//Comprueba que el agua no tenga ese color.
            System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
        }else{
            colorPj=COLORESPJ[eleccionColor];     //Si el agua es de otro color, asigna el color seleccionado al jugador.   
        }  
    }

    /**
     * Gestiona la eleccion de los colores del Policia comprobando que no estes eligiendo el mismo color que el Escapista.
     * @param eleccionColor
     */
    private static void gestorColorPo(int eleccionColor, String colorPj, String colorPo){
        eleccionColor=eleccionColor-1;
        if (colorPo==COLORESPJ[eleccionColor]) {//Comprueba que el agua no tenga ese color.
            System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
        }else{
            colorPo=COLORESPOLICIA[eleccionColor];     //Si el agua es de otro color, asigna el color seleccionado al jugador.   
        }  
    }

    /**
     * cambiarAspectoPJ. Te permite elegir el color del personaje.
     * @param bf
     * @throws IOException
     */
    private static void cambiarAspectoPJ(String[] MOSTRARMENUS, String colorPj, String colorPo) throws IOException{
        //cambias el aspecto del Personaje
        int eleccionColorPJ;
        opcionMenu= 4;
        max=9;
        min=1;
        //Muestra las opciones de colores.
        System.out.println("Has elegido cambiar el aspecto de tu personaje.");
        System.out.println(MOSTRARMENUS[opcionMenu]);
        eleccionColorPJ = Utilidades.leerEnteroValidado(min, max); //Lee la elección del color
        switch (eleccionColorPJ) { //Según la elección se mete en el case correspondiente.
            case 1:
            System.out.println("Has elegido el color rojo.");
            gestorColorPj(eleccionColorPJ, colorPj, colorPo);
            break;
        case 2:
            System.out.println("Has elegido el color verde.");
            gestorColorPj(eleccionColorPJ, colorPj, colorPo);                        
            break;
        case 3:
            System.out.println("Has elegido el color amarillo.");
            gestorColorPj(eleccionColorPJ, colorPj, colorPo);                    
            break;
        case 4:
            System.out.println("Has elegido el color azul.");
            gestorColorPj(eleccionColorPJ, colorPj, colorPo);
            break;
        case 5:
            System.out.println("Has elegido el color morado.");
            gestorColorPj(eleccionColorPJ, colorPj, colorPo);
            break;
        case 6:
            System.out.println("Has elegido el color Cian.");
            gestorColorPj(eleccionColorPJ, colorPj, colorPo);
            break;
        case 7:
            System.out.println("Has elegido el color Blanco.");
            gestorColorPj(eleccionColorPJ, colorPj, colorPo);                          
            break;
        case 8:
            System.out.println("Has elegido el color Negro.");
            gestorColorPj(eleccionColorPJ, colorPj, colorPo);
            break;
        case 9:
            System.out.println("Has elegido salir. Volviendo al menú de aspecto."); 
            break;
        default:
            //No pongo nada debido a que las validaciones correspondientes estan hechas.
            break;
        }
    }

    /**
     * cambiarAspectoPo. Te permite elegir el color del policia (AUN NO INCLUIDO EN EL JUEGO).
     * @param bf
     * @throws IOException
     */
    private static void cambiarAspectoPo(String[] MOSTRARMENUS, String colorPj, String colorPo) throws IOException{
        int eleccioncolorPo;
        opcionMenu= 5;
        max=9;
        min=1;
            //Muestra las opciones de colores.
            System.out.println("Has elegido cambiar el aspecto del Policia.");
            System.out.println(MOSTRARMENUS[opcionMenu]);
            eleccioncolorPo = Utilidades.leerEnteroValidado(min, max); //Lee el color elegido.
            switch (eleccioncolorPo) { //selecciona segun el número elegido.
                case 1:
                    System.out.println("Has elegido el color rojo.");
                    gestorColorPo(eleccioncolorPo, colorPj, colorPo);
                    break;
                case 2:
                    System.out.println("Has elegido el color verde.");                    
                    gestorColorPo(eleccioncolorPo, colorPj, colorPo);                       
                    break;
                case 3:
                    System.out.println("Has elegido el color amarillo.");                    
                    gestorColorPo(eleccioncolorPo, colorPj, colorPo);                      
                    break;
                case 4:
                    System.out.println("Has elegido el color azul.");                    
                    gestorColorPo(eleccioncolorPo, colorPj, colorPo);
                    break;
                case 5:
                    System.out.println("Has elegido el color morado.");                    
                    gestorColorPo(eleccioncolorPo, colorPj, colorPo);
                    break;
                case 6:
                    System.out.println("Has elegido el color Cian.");                    
                    gestorColorPo(eleccioncolorPo, colorPj, colorPo);
                    break;
                case 7:
                    System.out.println("Has elegido el color Blanco.");                    
                    gestorColorPo(eleccioncolorPo, colorPj, colorPo);                         
                    break;
                case 8:
                    System.out.println("Has elegido el color Negro.");                    
                    gestorColorPo(eleccioncolorPo, colorPj, colorPo);
                    break;    
                case 9:
                    System.out.println("Has elegido salir. Volviendo al menú principal.");                    
                    break;
                default:
                    //No pongo nada debido a que las validaciones correspondientes estan hechas.
                    break;
            }
        }
    
    /**
     * Aspecto. Te permite cambiar el Aspecto del personaje.
     * @author SDM
     * @param bf
     * @throws IOException
     */
    public static void cambiarAspecto(String[] MOSTRARMENUS, String colorPj, String colorPo) throws IOException{

        //Respuestas aspecto
        int reAspecto;// respuesta de elección de aspecto.


        boolean salirAspecto=false;
        //Aspecto
        salirAspecto=false; //Pone salirAspecto en false, ya que sino cuando eligieras cualquier cosa dentro de los submenús
        //Te sacaraía instantaneamente al menú general. 
        do { //Repite hasta que el usuario seleccione salir.
            opcionMenu= 3;
            max=3;
            min=1;
            //Muestra opciones de aspecto.
            System.out.println(MOSTRARMENUS[opcionMenu]);

            reAspecto = Utilidades.leerEnteroValidado(min, max); //Lee respuesta y la guarda en reAspecto

            switch (reAspecto) {
                case 1:
                    cambiarAspectoPJ(MOSTRARMENUS, colorPj, colorPo);// Llama al meteodo cambiarAspectoPJ y le envia el BufferedReader
                    break;
                case 2:
                    cambiarAspectoPo(MOSTRARMENUS, colorPj, colorPo);// Llama al meteodo cambiarAspectoPo y le envia el BufferedReader
                    break;
                case 3: 
                    System.out.println("Has elegido salir. Volviendo al menú principal.");
                    salirAspecto=true;//sale al menú principal.
                    break;
                default:
                    //No pongo nada debido a que las validaciones correspondientes estan hechas.
                    break;
            }


       }while (salirAspecto==false);
    }
    
}
