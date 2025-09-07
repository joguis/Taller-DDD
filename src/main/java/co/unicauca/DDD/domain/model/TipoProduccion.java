package co.unicauca.DDD.domain.model;

import java.util.Objects;

public class TipoProduccion {
    private final String tipo; // Ejemplo: "Orgánico", "Industrial", "Artesanal"

    public TipoProduccion(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo de producción no puede estar vacío");
        }
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoProduccion)) return false;
        TipoProduccion that = (TipoProduccion) o;
        return Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}