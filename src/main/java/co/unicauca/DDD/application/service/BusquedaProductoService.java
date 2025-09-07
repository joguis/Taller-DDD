package co.unicauca.DDD.application.service;

import co.unicauca.DDD.domain.model.Producto;
import co.unicauca.DDD.domain.service.FiltroProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusquedaProductoService {

    private final FiltroProductoService filtroProductoService;

    public BusquedaProductoService(FiltroProductoService filtroProductoService) {
        this.filtroProductoService = filtroProductoService;
    }

    public List<Producto> buscarPorFiltros(String nombre, String tipoProduccion, Boolean disponible) {
        return filtroProductoService.filtrarProductos(nombre, tipoProduccion, disponible);
    }
}