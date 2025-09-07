package co.unicauca.DDD.domain.repository;

import co.unicauca.DDD.domain.model.Categoria;
import co.unicauca.DDD.domain.model.Producto;

import java.util.List;
import java.util.UUID;

public interface ProductoRepository {
    Producto guardar(Producto producto);
    Producto buscarPorId(UUID id);
    List<Producto> listarTodos();
    List<Producto> filtrarPorCategoria(Categoria categoria);
}
