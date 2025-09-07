package co.unicauca.DDD.application.service;

import co.unicauca.DDD.domain.repository.ProductoRepository;
import co.unicauca.DDD.domain.service.ProductoDomainService;

public class ProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoDomainService productoDomainService;

    public ProductoService(ProductoRepository productoRepository, ProductoDomainService productoDomainService) {
        this.productoRepository = productoRepository;
        this.productoDomainService = productoDomainService;
    }

}
