package co.unicauca.DDD.ui.controller;

import co.unicauca.DDD.application.service.CategoriaService;
import co.unicauca.DDD.domain.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.crearCategoria(categoria);
    }

    public Optional<Categoria> obtenerCategoria(@PathVariable Long id) {
        return categoriaService.obtenerCategoriaPorId(id);
    }

    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    public void eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
    }
}