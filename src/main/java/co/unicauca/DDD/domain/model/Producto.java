package co.unicauca.DDD.domain.model;

import java.util.UUID;

public class Producto {
    private final UUID id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;

    public Producto(UUID id, String nombre, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }
}
