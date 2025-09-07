package co.unicauca.DDD.domain.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class Producto {
    private Long id;
    private String nombre;
    private Categoria categoria;//Uso del agregado
    private Disponibilidad disponibilidad;//Uso del objeto de valor
    private Temporada temporada;
    private TipoProduccion tipoProduccion;
    private List<ImagenProducto> imagenes;
    private String descripcion;

    public Producto(Long id, String nombre, Categoria categoria,
                    Disponibilidad disponibilidad, Temporada temporada,
                    TipoProduccion tipoProduccion, List<ImagenProducto> imagenes,
                    String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.disponibilidad = disponibilidad;
        this.temporada = temporada;
        this.tipoProduccion = tipoProduccion;
        this.imagenes = imagenes;
        this.descripcion = descripcion;
    }

    //Métodos del modelo de negocio
    public Disponibilidad cambiarDisponibilidad(Disponibilidad nuevaDisponibilidad) {
        return this.disponibilidad = nuevaDisponibilidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}