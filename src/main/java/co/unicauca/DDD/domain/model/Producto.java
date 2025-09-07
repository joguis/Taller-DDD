package co.unicauca.DDD.domain.model;

import java.util.List;
import java.util.Objects;

public class Producto {
    private Long id;
    private String nombre;
    private Categoria categoria;
    private Disponibilidad disponibilidad;
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

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Categoria getCategoria() { return categoria; }
    public Disponibilidad getDisponibilidad() { return disponibilidad; }
    public Temporada getTemporada() { return temporada; }
    public TipoProduccion getTipoProduccion() { return tipoProduccion; }
    public List<ImagenProducto> getImagenes() { return imagenes; }
    public String getDescripcion() { return descripcion; }

    public void cambiarDisponibilidad(Disponibilidad nuevaDisponibilidad) {
        this.disponibilidad = nuevaDisponibilidad;
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