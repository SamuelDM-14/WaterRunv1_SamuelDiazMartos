public class Policia extends Personajes {
    private int experiencia;
    public Policia(String color, int experiencia){
        super(color);
        this.experiencia = experiencia;
    }
    @Override
    public void accion(){
        System.out.println("El Policia intenta detener al escapista.");
    }

    public boolean disparar(Escapista escapista, int dificultad){
        boolean retrasaPregunta = false;
        if (dificultad == 2) {
            System.out.println("¡El policía dispara al escapista!");
            if (!escapista.esquivarDisparo(experiencia)) {
                System.out.println("¡El policía ha disparado! Se retrasa una pregunta.");
                retrasaPregunta = true;
            }
        }
        return retrasaPregunta;
    }
}
