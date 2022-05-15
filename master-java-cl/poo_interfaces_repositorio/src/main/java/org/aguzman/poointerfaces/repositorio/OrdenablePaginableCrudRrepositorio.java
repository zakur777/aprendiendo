package org.aguzman.poointerfaces.repositorio;

public interface OrdenablePaginableCrudRrepositorio<T> extends OrdenableRepositorio<T>
        , PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio {
}
