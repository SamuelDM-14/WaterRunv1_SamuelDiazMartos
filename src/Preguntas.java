public class Preguntas {

    private static String[][] preguntas= { // array de preguntas y respuestas para mostrar
        {"¿Cuanto es 2 + 2? \n1) 2\t\t 2) 4\t\t 3) 75\t\t 4)185 ","¿La palabra \"QUESO\" tiene 5 letras? \n1) Veradero\t\t 2) Falso",
            "¿Cuanto es 5x5?"},
        {"¿Cuál es el río más largo del mundo? \n1) Nilo\t\t 2) Amazonas\t\t 3) Tajo\t\t 4) Misisipi", 
        "¿Cuál es el país más grande del mundo? \n1) EEUU\t\t 2) China\t\t 3) Rusia\t\t 4) Canadá",
        "Marca el erroneo: \n1) Antártida\t\t 2) África\t\t 3) Asia\t\t 4) Polo Norte"},
        {"¿Cuantas medallas de oro tiene EEUU en los Juegos Olímpicos? \n1) 2102\t\t 2) 585\t\t 3) 1070\t\t 4) 2400", 
        "¿Cuanto tardó en construirse la torre Eiffel? \n1) 1 año y medio\t\t 2) 2 años y 8 meses\t\t 3) 1 año y 10 meses\t\t 4) 2 años y 2 meses", 
        "¿Cual es el animal más rápido del planeta? \n1) Halcón Peregrino\t\t 2) Tiburón Martillo\t\t 3) Guepardo\t\t 4) Pez Vela"}
    };
    private static int[][] respuestaCorrecta = {// array para comprobar las respuestas correctas
        {2, 1, 25},
        {2, 3, 4},
        {3, 4, 1}                        
    };

    public Preguntas(String pregunta, int dificultad, int numeroPregunta, int respuestaCorrecta){
        this.preguntas[dificultad][numeroPregunta]= pregunta;
        this.respuestaCorrecta[dificultad][numeroPregunta]= respuestaCorrecta;
    };

    
    public static String getPreguntas(int dificultad, int pregunta) { // obtiene la pregunta que hacer segun la dificultad
        return preguntas[dificultad][pregunta];
    }

    public static void setPreguntas(String pregunta, int dificultad, int numeroPregunta, String respuestaCorrecta) {
        Preguntas.preguntas[dificultad][numeroPregunta]= pregunta;
    }

    public static int getRespuestas(int dificultad, int respuesta){ // obtiene la respuesta correspondiente

        return respuestaCorrecta[dificultad][respuesta];
    }

    public static void setRespuestaCorrecta(int dificultad, int numeroPregunta, int respuestaCorrecta) {
        Preguntas.respuestaCorrecta[dificultad][numeroPregunta]= respuestaCorrecta;
    }

    public String toString() { // muesta la lista de todas las preguntas posibles.
        StringBuilder sb = new StringBuilder();
        sb.append("Listado de Preguntas y Respuestas Correctas:\n");
    
        for (int i = 0; i < preguntas.length; i++) {
            sb.append("\nDificultad ").append(i + 1).append(":\n");
    
            for (int j = 0; j < preguntas[i].length; j++) {
                sb.append("Pregunta ").append(j + 1).append(": ")
                  .append(preguntas[i][j]).append("\n");
    
                // Verifica si hay una respuesta correcta en la misma posición
                if (i < respuestaCorrecta.length && j < respuestaCorrecta[i].length) {
                    sb.append("   → Respuesta Correcta: ").append(respuestaCorrecta[i][j]).append("\n");
                }
            }
        }
        
        return sb.toString();
    }
}

