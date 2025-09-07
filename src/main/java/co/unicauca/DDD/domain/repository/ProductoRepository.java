package co.unicauca.DDD.domain.repository;

import co.unicauca.DDD.domain.model.Producto;
import co.unicauca.DDD.domain.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {

    Producto guardar(Producto producto);

    Optional<Producto> buscarPorId(Long id);

    List<Producto> buscarTodos();

    List<Producto> buscarPorCategoria(Categoria categoria);

    void eliminar(Long id);
}