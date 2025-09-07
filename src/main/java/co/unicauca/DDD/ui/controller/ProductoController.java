package co.unicauca.DDD.ui.controller;

import co.unicauca.DDD.application.service.ProductoService;
import co.unicauca.DDD.application.service.BusquedaProductoService;
import co.unicauca.DDD.domain.model.Producto;
// import co.unicauca.DDD.domain.model.Categoria;
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


    /**
     * Crea un nuevo producto con los parametros proporcionados.
     * @param producto
     * @return
     */
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    /**
     * Obteniene un producto dado por su id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Producto> obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }
    /**
      * Lista todos los productos que hay agregados
      * @return
      */
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }


    /**
     * Elimina un producto dado su id
     * @param id
     */
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}