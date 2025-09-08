package co.unicauca.DDD.infrastructure.repository;

import co.unicauca.DDD.domain.model.Producto;
import co.unicauca.DDD.domain.model.Categoria;
import co.unicauca.DDD.domain.repository.ProductoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Implementación del repositorio
 */
public class JpaProductoRepository implements ProductoRepository {

    private final Map<Long, Producto> bdProductos = new HashMap<>();
    
    @Override
    public Producto guardar(Producto objProducto){
        bdProductos.put(objProducto.getId(), objProducto);
        return objProducto;
    }

    @Override
    public Optional<Producto> buscarPorId(Long id){
        return Optional.ofNullable(bdProductos.get(id));
    }

    @Override
    public List<Producto> buscarTodos(){
        return List.copyOf(bdProductos.values());
    }

    @Override
    public List<Producto> buscarPorCategoria(Categoria categoria){
        return bdProductos.values().stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .toList();
    }

    @Override
    public void eliminar(Long id){
        bdProductos.remove(id);
    }
}