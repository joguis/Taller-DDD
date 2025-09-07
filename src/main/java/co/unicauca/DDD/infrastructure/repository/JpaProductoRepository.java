package co.unicauca.DDD.infrastructure.repository;

import co.unicauca.DDD.domain.model.Producto;
import co.unicauca.DDD.domain.model.Categoria;
import co.unicauca.DDD.domain.repository.ProductoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductoRepository extends JpaRepository<Producto, Long>, ProductoRepository {

    // Spring Data JPA creará la query automáticamente
    List<Producto> findByCategoria(Categoria categoria);
}