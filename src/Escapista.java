import java.util.Random;
public class Escapista extends Personajes {
    private Random random; // generador de números aleatorios

    public Escapista(String color) {
        super(color); // hereda el color del personaje
        this.random = new Random();

    }

    @Override
    public void accion() {
        System.out.println("El escapista está intentando escapar respondiendo preguntas.");
    }
    
    public boolean esquivarDisparo(int experienciaPolicia) {
        boolean esquivado = false;
        int probabilidad = (experienciaPolicia > 5) ? 10 : 3;
        int chance = random.nextInt(probabilidad) + 1; // Número aleatorio entre 1 y 2
        if (chance == 1) {
            System.out.println("¡El escapista ha esquivado el disparo del policía por lo que se puede mover!");
            esquivado = true;
        }else{
            System.out.println("¡El escapista no logró esquivar el disparo y se queda en el sitio!");
            esquivado = false;
        }
        return esquivado;
    }
}