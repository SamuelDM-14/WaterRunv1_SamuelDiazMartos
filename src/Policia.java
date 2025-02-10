public class Policia extends Personajes {
    private int experiencia;
    public Policia(String color, int experiencia){
        super(color); // hereda el color de Personajes
        this.experiencia = experiencia; //asigna la experiencia 
    }
    @Override
    public void accion(){
        System.out.println("El Policia intenta detener al escapista.");
    }

    public boolean disparar(Escapista escapista, int dificultad){
        boolean retrasaPregunta = false;
        if (dificultad == 2) { // comprueba que la dificultad sea 2 (Dificil)
            System.out.println("¡El policía dispara al escapista!");
            if (!escapista.esquivarDisparo(experiencia)) { // cuando esquivardisparo sea false el policia le da la bala.
                System.out.println("¡El policía ha disparado! Se retrasa una pregunta.");
                retrasaPregunta = true;
            }
        }
        return retrasaPregunta;
    }
}
