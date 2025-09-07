package co.unicauca.DDD.application.service;

import co.unicauca.DDD.domain.model.Categoria;
import co.unicauca.DDD.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.guardar(categoria);
    }

    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        return categoriaRepository.buscarPorId(id);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.buscarTodas();
    }

    public void eliminarCategoria(Long id) {
        categoriaRepository.eliminar(id);
    }
}