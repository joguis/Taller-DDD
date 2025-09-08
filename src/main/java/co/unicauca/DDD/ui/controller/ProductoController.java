package co.unicauca.DDD.ui.controller;

import co.unicauca.DDD.application.service.ProductoService;
import co.unicauca.DDD.application.service.BusquedaProductoService;
import co.unicauca.DDD.domain.model.Disponibilidad;
import co.unicauca.DDD.domain.model.Producto;
// import co.unicauca.DDD.domain.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ProductoController {

    private final ProductoService productoService;
    private final BusquedaProductoService busquedaProductoService;

    public ProductoController(ProductoService productoService, BusquedaProductoService busquedaProductoService) {
        this.productoService = productoService;
        this.busquedaProductoService = busquedaProductoService;
    }

    


    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
        this.busquedaProductoService= null;
    }




    /**
     * Crea un nuevo producto con los parametros proporcionados.
     * @param producto
     * @return
     */
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    /**
     * Obteniene un producto dado por su id
     * @param id
     * @return
     */
    public Optional<Producto> obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }
    /**
      * Lista todos los productos que hay agregados
      * @return
      */
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }


    /**
     * Elimina un producto dado su id
     * @param id
     */
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

    /**
     * 
     */
    public void modificarDisponibilidadProducto(Long id, Disponibilidad nuevaDisponibilidad) {
        Optional<Producto> productoOpt = productoService.obtenerProductoPorId(id);
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            producto.cambiarDisponibilidad(nuevaDisponibilidad);
            productoService.crearProducto(producto); // Guardar los cambios
        } else {
            throw new IllegalArgumentException("Producto con ID " + id + " no encontrado.");
        }
    }
}