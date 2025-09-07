package co.unicauca.DDD.domain.model;

import java.util.Objects;


/**
 * Objeto de valor que represena si un producto está disponible o no y su stock.
 * @author María Camila Hoyos Gómez
 * @author José Guillermo Segura Casas
 * @author Jeison Andrés Vallejo Vallejo
 */
public class Disponibilidad {
    private final boolean disponible;
    private final int stock;

    public Disponibilidad(boolean disponible, int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.disponible = disponible;
        this.stock = stock;
    }

    public boolean isDisponible() { return disponible; }
    public int getStock() { return stock; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disponibilidad)) return false;
        Disponibilidad that = (Disponibilidad) o;
        return disponible == that.disponible && stock == that.stock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(disponible, stock);
    }
}