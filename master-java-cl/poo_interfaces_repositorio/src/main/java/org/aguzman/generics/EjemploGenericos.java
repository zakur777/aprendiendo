package org.aguzman.generics;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.modelo.ClientesPremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
  public static void main(String[] args) {
    List<Cliente> clientes = new ArrayList<>();

    clientes.add(new Cliente("Andres", "Guzmán"));
    Cliente andres = clientes.iterator().next();

    Cliente[] clientesArreglo = {new Cliente("Luci", "Martinez"), new Cliente("Andres", "Guzmán")};

    Integer[] enterosArreglo = {1, 2, 3};

    List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
    List<Integer> enterosLista = fromArrayToList(enterosArreglo);

    clientesLista.forEach(System.out::println);
    enterosLista.forEach(System.out::println);

    List<String> nombres =
        fromArrayToList(new String[] {"Andres", "Pepe", "Luci", "Bea", "John"}, enterosArreglo);
    nombres.forEach(System.out::println);

    List<ClientesPremium> clientesPremiumList =
        fromArrayToList(new ClientesPremium[] {new ClientesPremium("Paco", "Fernandez")});

    System.out.println("****** Clientes ******");
    imprimirClientes(clientes);
    System.out.println("****** CLientes Lista ******");
    imprimirClientes(clientesLista);
    System.out.println("****** Clientes Premium ******");
    imprimirClientes(clientesPremiumList);

    System.out.println("Máximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
    System.out.println("Máximo de 3.9, 11.6, 7.78 es: " + maximo(3.9, 11.6, 7.78));
    System.out.println(
        "Máximo de zanahoria, arándanos, manzana es: "
            + maximo("zanahoria", "arándanos", "manzana"));
  }

  public static <T> List<T> fromArrayToList(T[] c) {
    return Arrays.asList(c);
  }

  public static <T extends Number> List<T> fromArrayToList(T[] c) {
    return Arrays.asList(c);
  }

  public static <T extends Cliente> List<T> fromArrayToList(T[] c) {
    return Arrays.asList(c);
  }

  public static <T, G> List<T> fromArrayToList(T[] c, G[] x) {
    for (G elemento : x) {
      System.out.println(elemento);
    }
    return Arrays.asList(c);
  }

  public static void imprimirClientes(List<? extends Cliente> clientes) {
    clientes.forEach(System.out::println);
  }

  public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
    T max = a;
    if (b.compareTo(max) > 0) {
      max = b;
    }
    if (c.compareTo(max) > 0) {
      max = c;
    }
    return max;
  }
}
