package exceptions;

class RecursoDevs4j implements AutoCloseable {

    void foo() {
        System.out.println("Foo");
    }

    @Override
    public void close() {
        System.out.println("Liberando recursos");
    }
}

public class EjemploTryWithResources {
    public static void main(String[] args) {
        try (RecursoDevs4j recurso = new RecursoDevs4j()) {
            recurso.foo();
        }
    }
}
