package gestionjuego.salir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utilidades.VarGenYConst;

public class PartidasTxt {
    private static boolean txtPartidasCreado = false;
    private static String txtPartidas;

    public static void GuardarPartidasTxt() {
        crearArchivoTxt();
        PrintWriter escribir = null;
        try {
            FileWriter fw = new FileWriter(txtPartidas, true);
            BufferedWriter bw = new BufferedWriter(fw);

            escribir = new PrintWriter(bw);

            escribir.println("----- PARTIDAS -----");
            escribir.println("Fecha de sesion: " + new Date());
            escribir.println(VarGenYConst.partidasSesion);
        } catch (IOException IOe) {
            System.err.println("No se pudo escribir en el archivo de log: " + IOe.getMessage());
        } finally {
            if (escribir != null) {
                escribir.close();
            }
        }
        ;
    }

    private static void crearArchivoTxt() {
        if (!txtPartidasCreado) {
            txtPartidas = "Partidas.txt";
            txtPartidasCreado = true;
        }
    }

    public static void MostrarPartidasTxt() {
    crearArchivoTxt();

    List<String> lineas = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(txtPartidas))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
        }
    } catch (IOException e) {
        System.err.println("No se pudo leer el archivo: " + e.getMessage());
        return;
    }

    // Buscar el índice de la última "Fecha de sesion:"
    int ultimaSesionIndex = -1;
    for (int i = 0; i < lineas.size(); i++) {
        if (lineas.get(i).startsWith("Fecha de sesion:")) {
            ultimaSesionIndex = i;
        }
    }

    // Mostrar desde la última sesión en adelante
    if (ultimaSesionIndex != -1) {
        System.out.println("----- PARTIDAS DE LA ÚLTIMA SESIÓN -----");
        for (int i = ultimaSesionIndex - 1; i < lineas.size(); i++) {
            // Comenzamos desde -1 para incluir el "----- PARTIDAS -----"
            if (i >= 0) System.out.println(lineas.get(i));
        }
    } else {
        System.out.println("No se encontró ninguna sesión registrada.");
    }
}

}
