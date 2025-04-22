package gestionjuego.salir;

import utilidades.VarGenYConst;

public class GestionSalir {

    public static void salir(){

        if (VarGenYConst.partidasSesion.isEmpty()) {
            System.out.println("Saliendo del juego");
        }else{
            PartidasTxt.GuardarPartidasTxt();
            System.out.println("Estas han sido tus partidas: ");
            PartidasTxt.MostrarPartidasTxt();
            System.out.println("Saliendo del juego"); 
        }

    }
}
