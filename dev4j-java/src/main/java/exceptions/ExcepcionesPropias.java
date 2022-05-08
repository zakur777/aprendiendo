package exceptions;

class TituloIncorrectoException extends Exception {

    public TituloIncorrectoException(String error) {
        super(error);
    }
}

public class ExcepcionesPropias {
    static void crearCurso(String titulo) throws TituloIncorrectoException {
        if (!titulo.toUpperCase().equals(titulo)) {
            throw new TituloIncorrectoException("El titulo debe estar en mayusculas");
        }
        System.out.println("Título correcto");
    }

    public static void main(String[] args) {
        try {
            crearCurso("JAVA DeSDE CERO  PROFUNDIDAD");
        } catch (TituloIncorrectoException e) {
            System.out.println("Error " + e.getMessage());
        }
    }


}
