package co.unicauca.DDD.domain.service;

import co.unicauca.DDD.domain.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiltroProductoService {

    private final List<Producto> productos;

    // Inyectar una lista puede ser provisional, en realidad debería consultarse al repositorio
    public FiltroProductoService(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> filtrarProductos(String nombre, String tipoProduccion, Boolean disponible) {
        return productos.stream()
                .filter(p -> nombre == null || p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .filter(p -> tipoProduccion == null || p.getTipoProduccion().getTipo().equalsIgnoreCase(tipoProduccion))
                .filter(p -> disponible == null || p.getDisponibilidad().isDisponible() == disponible)
                .collect(Collectors.toList());
    }
}