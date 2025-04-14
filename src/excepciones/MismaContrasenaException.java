package excepciones;


public class MismaContrasenaException extends Exception{
    public MismaContrasenaException (String mensaje){
        super(mensaje);
    }
}
