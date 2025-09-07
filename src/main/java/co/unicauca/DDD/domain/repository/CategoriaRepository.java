package co.unicauca.DDD.domain.repository;

import co.unicauca.DDD.domain.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {

    Categoria guardar(Categoria categoria);

    Optional<Categoria> buscarPorId(Long id);

    List<Categoria> buscarTodas();

    void eliminar(Long id);
}