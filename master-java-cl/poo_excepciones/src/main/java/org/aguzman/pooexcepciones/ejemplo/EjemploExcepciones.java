package org.aguzman.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
  public static void main(String[] args) {
    Calculadora cal = new Calculadora();
    String valor = JOptionPane.showInputDialog("Ingrese un entero");
    int divisor;
    double division;
    // double division = cal.dividir(10, divisor);
    try {
      divisor = Integer.parseInt(valor);
      division = cal.dividir(10, divisor);
      System.out.println(division);

      double division2 = cal.dividir("10", "5");
      System.out.println("division2 = " + division2);
    } catch (NumberFormatException nfe) {
      System.out.println(
          "Se detecto una excepción: por favor ingrese un valor númerico " + nfe.getMessage());
    } catch (FormatoNumeroException e) {
      System.out.println("Se detecto una excepción: ingrese un número valido: " + e.getMessage());
      e.printStackTrace(System.out);
    } catch (DivisionPorZeroException ae) {
      System.out.println("Capturamos la excepcion en tiempo de ejecución: " + ae.getMessage());
    } finally {
      System.out.println("Es opcional, pero se ejecuta siempre con o sin excepcion");
    }
    System.out.println("Continuamos con el flujo de nuestra aplicación");
  }
}
