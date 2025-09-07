package co.unicauca.DDD.application.service;

import co.unicauca.DDD.domain.model.Categoria;
import co.unicauca.DDD.domain.model.Producto;
import co.unicauca.DDD.domain.repository.ProductoRepository;
import co.unicauca.DDD.domain.service.ProductoDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoDomainService productoDomainService;

    public ProductoService(ProductoRepository productoRepository,
                           ProductoDomainService productoDomainService) {
        this.productoRepository = productoRepository;
        this.productoDomainService = productoDomainService;
    }

    public Producto crearProducto(Producto producto) {
        if (!productoDomainService.esValido(producto)) {
            throw new IllegalArgumentException("El producto no es válido");
        }
        return productoRepository.guardar(producto);
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.buscarPorId(id);
    }

    public List<Producto> listarProductos() {
        return productoRepository.buscarTodos();
    }

    public List<Producto> listarPorCategoria(Categoria categoria) {
        return productoRepository.buscarPorCategoria(categoria);
    }

    public void eliminarProducto(Long id) {
        productoRepository.eliminar(id);
    }
}