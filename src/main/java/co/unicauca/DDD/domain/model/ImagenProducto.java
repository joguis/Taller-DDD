package co.unicauca.DDD.domain.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class ImagenProducto {
    private final String url;
    private final String descripcion;

    public ImagenProducto(String url, String descripcion) {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("La URL de la imagen no puede estar vacía");
        }
        this.url = url;
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImagenProducto)) return false;
        ImagenProducto that = (ImagenProducto) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, descripcion);
    }
}