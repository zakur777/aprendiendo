package exceptions;

public class EjemploThrow {
    static double dividir(int a, int b) throws Exception {
        if (b != 0) {
            return a / b;

        } else {
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
    }

    public static void main(String[] args) {
        double resultado = 0;
        try {
            resultado = dividir(10,0);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        System.out.println("Resultado " + resultado);
    }
}
