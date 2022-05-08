package exceptions;

public class EjemploTryCatch {

    public static void main(String[] args) {
        try {
            int x = 10;
            int y = 10 / x;
            System.out.println("Valor de la division" + y);

            String nombre = "Alex";
            System.out.println(nombre.toString());

            String arr[] = {"raidentrance", "devs4j"};
            System.out.println(arr[3]);


        } catch (ArithmeticException | NullPointerException e) {
            System.err.printf("Aritmethic y NullPointer exception %s \n", e.getMessage());

        } catch (Exception e) {
            System.err.printf("Exception %s \n", e.getMessage());
        } finally {
            System.out.println("Siempre se ejecuta");
        }
    }
}
