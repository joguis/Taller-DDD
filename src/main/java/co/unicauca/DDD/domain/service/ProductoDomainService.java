package co.unicauca.DDD.domain.service;

import co.unicauca.DDD.domain.model.Producto;
import org.springframework.stereotype.Service;

@Service
public class ProductoDomainService {

    public boolean esValido(Producto producto) {
        return producto != null &&
                producto.getNombre() != null && !producto.getNombre().isBlank() &&
                producto.getCategoria() != null;
    }
}