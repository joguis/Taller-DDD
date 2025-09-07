package co.unicauca.DDD.infrastructure.repository;

import co.unicauca.DDD.domain.model.Categoria;
import co.unicauca.DDD.domain.repository.CategoriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoriaRepository extends JpaRepository<Categoria, Long>, CategoriaRepository {
}