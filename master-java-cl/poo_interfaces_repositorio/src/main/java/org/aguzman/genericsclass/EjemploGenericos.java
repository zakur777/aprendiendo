package org.aguzman.genericsclass;

public class EjemploGenericos {
  public static <T> void imprimirCamion(Camion<T> camion) {
    for (T a : camion) {
      if (a instanceof Animal) {
        System.out.println(((Animal) a).getNombre() + " tipo: " + ((Animal) a).getTipo());
      } else if (a instanceof Maquinaria) {
        System.out.println(((Maquinaria) a).getTipo());
      } else if (a instanceof Automovil) {
        System.out.println(((Automovil) a).getMarca());
      }
    }
  }

  public static void main(String[] args) {
    Camion<Animal> transporteCaballos = new Camion<>(5);
    transporteCaballos.add(new Animal("Peregrino", "Caballo"));
    transporteCaballos.add(new Animal("grillo", "Caballo"));
    transporteCaballos.add(new Animal("Tunquen", "Caballo"));
    transporteCaballos.add(new Animal("Topocalma", "Caballo"));
    transporteCaballos.add(new Animal("Longotoma", "Caballo"));

    imprimirCamion(transporteCaballos);

    Camion<Maquinaria> transMquinas = new Camion<>(3);
    transMquinas.add(new Maquinaria("Bulldozer"));
    transMquinas.add(new Maquinaria("Gruá Horquilla"));
    transMquinas.add(new Maquinaria("Perforadora"));

    imprimirCamion(transMquinas);

    Camion<Automovil> transAuto = new Camion<>(3);
    transAuto.add(new Automovil("Toyota"));
    transAuto.add(new Automovil("Mitsubishi"));
    transAuto.add(new Automovil("Chevrolet"));

    imprimirCamion(transAuto);
  }
}
