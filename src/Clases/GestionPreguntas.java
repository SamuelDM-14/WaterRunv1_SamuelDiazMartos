package Clases;
/**
 * Clase que gestiona las preguntas del juego separadas por dificultad,
 * usando un array bidimensional de objetos Pregunta.
 * 
 * dificultad: 0 = fácil, 1 = media, 2 = difícil
 * índice de pregunta: 0..n-1
 */
public class GestionPreguntas {

    private static final int NUM_DIFICULTADES = 3; // 0,1,2
    private static final int NUM_PREGUNTAS = 3;   // Por ejemplo, 3 preguntas por dificultad

    // preguntas[dificultad][indicePregunta]
    private Pregunta[][] preguntas;

    /**
     * Constructor de GestionPreguntas.
     * Inicializa el array y carga algunas preguntas de ejemplo.
     */
    public GestionPreguntas() {
        preguntas = new Pregunta[NUM_DIFICULTADES][NUM_PREGUNTAS];
        cargarPreguntas();
    }

    /**
     * Carga preguntas de ejemplo en el array. Ajusta según necesites.
     */
    private void cargarPreguntas() {
        // ---------- Dificultad 0 = FÁCIL ----------
        // Pregunta 0:
        String[] opcionesF1 = {"2", "4", "75", "185"};
        preguntas[0][0] = new Pregunta("¿Cuánto es 2 + 2?", opcionesF1, "4");

        // Pregunta 1:
        String[] opcionesF2 = {"Verdadero", "Falso", " 6", ""};
        preguntas[0][1] = new Pregunta("La palabra 'QUESO' tiene 5 letras?", opcionesF2, "Verdadero");

        // Pregunta 2:
        String[] opcionesF3 = {"10", "20", "25", "0"};
        preguntas[0][2] = new Pregunta("¿Cuánto es 5 x 5?", opcionesF3, "25");

        // ---------- Dificultad 1 = MEDIA ----------
        // Pregunta 0:
        String[] opcionesM1 = {"Nilo", "Amazonas", "Tajo", "Misisipi"};
        preguntas[1][0] = new Pregunta("¿Cuál es el río más largo del mundo?", opcionesM1, "Amazonas");

        // Pregunta 1:
        String[] opcionesM2 = {"EEUU", "China", "Rusia", "Canadá"};
        preguntas[1][1] = new Pregunta("¿Cuál es el país más grande del mundo?", opcionesM2, "Rusia");

        // Pregunta 2:
        String[] opcionesM3 = {"Antártida", "África", "Asia", "Polo Norte"};
        preguntas[1][2] = new Pregunta("Marca el erróneo:", opcionesM3, "Polo Norte");

        // ---------- Dificultad 2 = DIFÍCIL ----------
        // Pregunta 0:
        String[] opcionesD1 = {"2102", "585", "1070", "2400"};
        preguntas[2][0] = new Pregunta("¿Cuántas medallas de oro tiene EEUU en los Juegos Olímpicos?", opcionesD1, "1070");

        // Pregunta 1:
        String[] opcionesD2 = {"1 año y medio", "2 años y 8 meses", "1 año y 10 meses", "2 años y 2 meses"};
        preguntas[2][1] = new Pregunta("¿Cuánto tardó en construirse la torre Eiffel?", opcionesD2, "2 años y 2 meses");

        // Pregunta 2:
        String[] opcionesD3 = {"Halcón Peregrino", "Tiburón Martillo", "Guepardo", "Pez Vela"};
        preguntas[2][2] = new Pregunta("¿Cuál es el animal más rápido del planeta?", opcionesD3, "Halcón Peregrino");
    }

    /**
     * Devuelve el objeto Pregunta, dada la dificultad y el índice de pregunta.
     * @param dificultad 0 = fácil, 1 = media, 2 = difícil
     * @param indicePregunta 0..(NUM_PREGUNTAS-1)
     * @return El objeto Pregunta correspondiente, o null si está fuera de rango.
     */
    public Pregunta getPregunta(int dificultad, int indicePregunta) {
        if (dificultad < 0 || dificultad >= NUM_DIFICULTADES) {
            return null;
        }
        if (indicePregunta < 0 || indicePregunta >= NUM_PREGUNTAS) {
            return null;
        }
        return preguntas[dificultad][indicePregunta];
    }

    /**
     * Devuelve cuántas preguntas tiene cada dificultad (por ejemplo, 3).
     */
    public int getNumPreguntas() {
        return NUM_PREGUNTAS;
    }
}
