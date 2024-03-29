package org.aguzman.poointerfaces;

import org.aguzman.poointerfaces.modelo.Producto;
import org.aguzman.poointerfaces.repositorio.Direccion;
import org.aguzman.poointerfaces.repositorio.OrdenablePaginableCrudRrepositorio;
import org.aguzman.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.aguzman.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.aguzman.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.aguzman.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
  public static void main(String[] args) {
    try {
      OrdenablePaginableCrudRrepositorio<Producto> repo = new ProductoListRepositorio();
      repo.crear(new Producto("mesa", 50.52));
      repo.crear(new Producto("silla", 18d));
      repo.crear(new Producto("lampara", 15.5));
      repo.crear(new Producto("notebook", 400.89));

      List<Producto> Productos = repo.listar();
      Productos.forEach(System.out::println);
      System.out.println("===== paginable =====");
      List<Producto> paginable = repo.listar(1, 3);
      paginable.forEach(System.out::println);

      System.out.println("===== ordenar =====");
      List<Producto> productosOrdenAsc = repo.listar("apellido", Direccion.ASC);

      for (Producto c : productosOrdenAsc) {
        System.out.println(c);
      }

      System.out.println("===== editar =====");
      Producto lamparaActualizar = new Producto("lampara escritorio", 23d);
      lamparaActualizar.setId(3);
      repo.editar(lamparaActualizar);
      Producto lampara = repo.porId(3);
      System.out.println(lampara);
      System.out.println(" ============ ");
      repo.listar("descripcion", Direccion.ASC).forEach(System.out::println);

      System.out.println("===== eliminar =====");
      repo.eliminar(2);
      repo.listar().forEach(System.out::println);

      System.out.println("===== total =====");
      System.out.println("Total de registros: " + repo.total());
    } catch (LecturaAccesoDatoException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    } catch (EscrituraAccesoDatoException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    } catch (AccesoDatoException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
