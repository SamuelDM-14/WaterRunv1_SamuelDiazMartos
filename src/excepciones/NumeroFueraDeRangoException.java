package excepciones;

public class NumeroFueraDeRangoException extends Exception {
    public NumeroFueraDeRangoException (String mensaje){
        super(mensaje);
    }
}
