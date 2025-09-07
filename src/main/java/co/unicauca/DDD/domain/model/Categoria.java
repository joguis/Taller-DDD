package co.unicauca.DDD.domain.model;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

import jakarta.persistence.Entity;

@NoArgsConstructor
@Setter
@Entity
public class Categoria {
    private Long id;
    private String nombre;

    public Categoria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria that = (Categoria) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}