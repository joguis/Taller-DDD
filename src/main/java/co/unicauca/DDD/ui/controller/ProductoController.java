package co.unicauca.DDD.ui.controller;

import co.unicauca.DDD.application.service.ProductoService;
import co.unicauca.DDD.application.service.BusquedaProductoService;
import co.unicauca.DDD.domain.model.Producto;
import co.unicauca.DDD.domain.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final BusquedaProductoService busquedaProductoService;

    public ProductoController(ProductoService productoService, BusquedaProductoService busquedaProductoService) {
        this.productoService = productoService;
        this.busquedaProductoService = busquedaProductoService;
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @GetMapping("/{id}")
    public Optional<Producto> obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}