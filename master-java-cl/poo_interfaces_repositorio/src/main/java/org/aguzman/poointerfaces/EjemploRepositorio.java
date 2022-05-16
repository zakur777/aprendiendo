package org.aguzman.poointerfaces;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.aguzman.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.aguzman.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.aguzman.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import org.aguzman.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.aguzman.poointerfaces.repositorio.Direccion;
import org.aguzman.poointerfaces.repositorio.OrdenablePaginableCrudRrepositorio;

import java.util.List;

public class EjemploRepositorio {
  public static void main(String[] args) {
    try {
      OrdenablePaginableCrudRrepositorio<Cliente> repo = new ClienteListRepositorio();
      repo.crear(new Cliente("Jano", "Perez"));
      repo.crear(new Cliente("Bea", "González"));
      repo.crear(new Cliente("Luci", "Martinez"));
      Cliente walter = new Cliente("Walter", "Barra");
      repo.crear(walter);
      repo.crear(walter);

      List<Cliente> clientes = repo.listar();
      clientes.forEach(System.out::println);
      System.out.println("===== paginable =====");
      List<Cliente> paginable = repo.listar(1, 3);
      paginable.forEach(System.out::println);

      System.out.println("===== ordenar =====");
      List<Cliente> clienteOrdenAsc = repo.listar("apellido", Direccion.ASC);

      for (Cliente c : clienteOrdenAsc) {
        System.out.println(c);
      }

      System.out.println("===== editar =====");
      Cliente beaActualizar = new Cliente("Bea", "Mena");
      beaActualizar.setId(2);
      repo.editar(beaActualizar);
      Cliente bea = repo.porId(2);
      System.out.println(bea);
      System.out.println(" ============ ");
      repo.listar("apellido", Direccion.ASC).forEach(System.out::println);

      System.out.println("===== eliminar =====");
      repo.eliminar(2);
      repo.listar().forEach(System.out::println);

      System.out.println("===== total =====");
      System.out.println("Total de registros: " + repo.total());
    } catch (RegistroDuplicadoAccesoDatoException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
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
