package co.unicauca.DDD.ui.controller;

import co.unicauca.DDD.application.service.CategoriaService;
import co.unicauca.DDD.domain.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.crearCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Optional<Categoria> obtenerCategoria(@PathVariable Long id) {
        return categoriaService.obtenerCategoriaPorId(id);
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
    }
}