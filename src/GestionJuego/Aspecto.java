/**
 * Aspecto
 * @author SDM
 * 14-03-2025
 */
package gestionjuego;

import java.io.IOException;

import utilidades.Utilidades;
import utilidades.VarGenYConst;
public class Aspecto {
    /**
     * Gestiona la eleccion de los colores del Escapista comprobando que no estes eligiendo el mismo color que el Policia
     * @param eleccionColor
     */
    private static void gestorColorPj(int eleccionColor){
        eleccionColor=eleccionColor-1;
        if (VarGenYConst.colorPj==VarGenYConst.COLORESPOLICIA[eleccionColor]) {//Comprueba que el agua no tenga ese color.
            System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
        }else{
            VarGenYConst.colorPj=VarGenYConst.COLORESPJ[eleccionColor];     //Si el agua es de otro color, asigna el color seleccionado al jugador.   
        }  
    }

    /**
     * Gestiona la eleccion de los colores del Policia comprobando que no estes eligiendo el mismo color que el Escapista.
     * @param eleccionColor
     */
    private static void gestorColorPo(int eleccionColor){
        eleccionColor=eleccionColor-1;
        if (VarGenYConst.colorPo==VarGenYConst.COLORESPJ[eleccionColor]) {//Comprueba que el agua no tenga ese color.
            System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
        }else{
            VarGenYConst.colorPo=VarGenYConst.COLORESPOLICIA[eleccionColor];     //Si el agua es de otro color, asigna el color seleccionado al jugador.   
        }  
    }

    /**
     * cambiarAspectoPJ. Te permite elegir el color del personaje.
     * @param bf
     * @throws IOException
     */
    private static void cambiarAspectoPJ() throws IOException{
        //cambias el aspecto del Personaje
        int eleccionColorPJ;
        VarGenYConst.opcionMenu= 4;
        VarGenYConst.max=9;
        VarGenYConst.min=1;
        //Muestra las opciones de colores.
        System.out.println("Has elegido cambiar el aspecto de tu personaje.");
        System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);
        eleccionColorPJ = Utilidades.leerEnteroValidado(); //Lee la elección del color
        switch (eleccionColorPJ) { //Según la elección se mete en el case correspondiente.
            case 1:
            System.out.println("Has elegido el color rojo.");
            gestorColorPj(eleccionColorPJ);
            break;
        case 2:
            System.out.println("Has elegido el color verde.");
            gestorColorPj(eleccionColorPJ);                        
            break;
        case 3:
            System.out.println("Has elegido el color amarillo.");
            gestorColorPj(eleccionColorPJ);                    
            break;
        case 4:
            System.out.println("Has elegido el color azul.");
            gestorColorPj(eleccionColorPJ);
            break;
        case 5:
            System.out.println("Has elegido el color morado.");
            gestorColorPj(eleccionColorPJ);
            break;
        case 6:
            System.out.println("Has elegido el color Cian.");
            gestorColorPj(eleccionColorPJ);
            break;
        case 7:
            System.out.println("Has elegido el color Blanco.");
            gestorColorPj(eleccionColorPJ);                          
            break;
        case 8:
            System.out.println("Has elegido el color Negro.");
            gestorColorPj(eleccionColorPJ);
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
    private static void cambiarAspectoPo() throws IOException{
        int eleccioncolorPo;
        VarGenYConst.opcionMenu= 5;
        VarGenYConst.max=9;
        VarGenYConst.min=1;
            //Muestra las opciones de colores.
            System.out.println("Has elegido cambiar el aspecto del Policia.");
            System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);
            eleccioncolorPo = Utilidades.leerEnteroValidado(); //Lee el color elegido.
            switch (eleccioncolorPo) { //selecciona segun el número elegido.
                case 1:
                    System.out.println("Has elegido el color rojo.");
                    gestorColorPo(eleccioncolorPo);
                    break;
                case 2:
                    System.out.println("Has elegido el color verde.");                    
                    gestorColorPo(eleccioncolorPo);                       
                    break;
                case 3:
                    System.out.println("Has elegido el color amarillo.");                    
                    gestorColorPo(eleccioncolorPo);                      
                    break;
                case 4:
                    System.out.println("Has elegido el color azul.");                    
                    gestorColorPo(eleccioncolorPo);
                    break;
                case 5:
                    System.out.println("Has elegido el color morado.");                    
                    gestorColorPo(eleccioncolorPo);
                    break;
                case 6:
                    System.out.println("Has elegido el color Cian.");                    
                    gestorColorPo(eleccioncolorPo);
                    break;
                case 7:
                    System.out.println("Has elegido el color Blanco.");                    
                    gestorColorPo(eleccioncolorPo);                         
                    break;
                case 8:
                    System.out.println("Has elegido el color Negro.");                    
                    gestorColorPo(eleccioncolorPo);
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
    public static void cambiarAspecto() throws IOException{

        //Respuestas aspecto
        int reAspecto;// respuesta de elección de aspecto.


        boolean salirAspecto=false;
        //Aspecto
        salirAspecto=false; //Pone salirAspecto en false, ya que sino cuando eligieras cualquier cosa dentro de los submenús
        //Te sacaraía instantaneamente al menú general. 
        do { //Repite hasta que el usuario seleccione salir.
            VarGenYConst.opcionMenu= 3;
            VarGenYConst.max=3;
            VarGenYConst.min=1;
            //Muestra opciones de aspecto.
            System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);

            reAspecto = Utilidades.leerEnteroValidado(); //Lee respuesta y la guarda en reAspecto

            switch (reAspecto) {
                case 1:
                    cambiarAspectoPJ();// Llama al meteodo cambiarAspectoPJ y le envia el BufferedReader
                    break;
                case 2:
                    cambiarAspectoPo();// Llama al meteodo cambiarAspectoPo y le envia el BufferedReader
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
