package co.unicauca.DDD.infrastructure.storage;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private final Path directorioBase = Paths.get("uploads");

    public FileStorageService() {
        try {
            if (!Files.exists(directorioBase)) {
                Files.createDirectories(directorioBase);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error creando directorio base para almacenamiento de archivos", e);
        }
    }

    /**
     * Guarda un archivo en el sistema de archivos.
     *
     * @param file archivo recibido (ej: imagen de producto).
     * @return ruta relativa del archivo guardado.
     */
    public String guardarArchivo(MultipartFile file) {
        try {
            Path destino = this.directorioBase.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), destino);
            return destino.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar archivo: " + file.getOriginalFilename(), e);
        }
    }

    /**
     * Obtiene un archivo como bytes.
     *
     * @param nombreArchivo nombre o ruta del archivo a buscar.
     * @return contenido del archivo en bytes.
     */
    public byte[] obtenerArchivo(String nombreArchivo) {
        try {
            Path ruta = this.directorioBase.resolve(nombreArchivo);
            return Files.readAllBytes(ruta);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer archivo: " + nombreArchivo, e);
        }
    }

    /**
     * Elimina un archivo.
     *
     * @param nombreArchivo nombre o ruta del archivo.
     */
    public void eliminarArchivo(String nombreArchivo) {
        try {
            Path ruta = this.directorioBase.resolve(nombreArchivo);
            Files.deleteIfExists(ruta);
        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar archivo: " + nombreArchivo, e);
        }
    }
}