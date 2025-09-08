package co.unicauca.DDD.domain.service;

import co.unicauca.DDD.domain.model.Categoria;
import co.unicauca.DDD.domain.model.Producto;
import org.springframework.stereotype.Service;

@Service
public class ClasificacionDomainService {

    public boolean perteneceACategoria(Producto producto, Categoria categoria) {
        return producto.getCategoria().equals(categoria);
    }
}