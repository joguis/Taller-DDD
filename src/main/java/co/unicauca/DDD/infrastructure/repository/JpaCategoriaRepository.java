package co.unicauca.DDD.infrastructure.repository;

import co.unicauca.DDD.domain.model.Categoria;
import co.unicauca.DDD.domain.repository.CategoriaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Implementación del repositorio
 */
public class JpaCategoriaRepository implements CategoriaRepository {

    private final Map<Long, Categoria> bdCategorías = new HashMap<>();

    @Override
    public Categoria guardar(Categoria categoria)
    {
        bdCategorías.put(categoria.getId(), categoria);
        return categoria;
    }

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return Optional.ofNullable(bdCategorías.get(id));
    }

    @Override
    public List<Categoria> buscarTodas() {
        return List.copyOf(bdCategorías.values());
    }

    @Override
    public void eliminar(Long id) {
        bdCategorías.remove(id);
    }
}