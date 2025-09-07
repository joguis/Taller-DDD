package co.unicauca.DDD.domain.model;

import java.time.LocalDate;
import java.util.Objects;

public class Temporada {
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;

    public Temporada(LocalDate fechaInicio, LocalDate fechaFin) {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la de fin");
        }
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean estaEnTemporada(LocalDate fecha) {
        return (fecha.isEqual(fechaInicio) || fecha.isAfter(fechaInicio)) &&
                (fecha.isEqual(fechaFin) || fecha.isBefore(fechaFin));
    }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temporada)) return false;
        Temporada that = (Temporada) o;
        return Objects.equals(fechaInicio, that.fechaInicio) &&
                Objects.equals(fechaFin, that.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaInicio, fechaFin);
    }
}