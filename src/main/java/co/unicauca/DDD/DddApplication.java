package co.unicauca.DDD;

import java.util.List;

import co.unicauca.DDD.application.service.CategoriaService;
import co.unicauca.DDD.application.service.ProductoService;
import co.unicauca.DDD.domain.model.Categoria;
import co.unicauca.DDD.domain.model.Disponibilidad;
import co.unicauca.DDD.domain.model.Producto;
import co.unicauca.DDD.domain.service.ClasificacionDomainService;
import co.unicauca.DDD.domain.service.ProductoDomainService;
import co.unicauca.DDD.infrastructure.repository.JpaCategoriaRepository;
import co.unicauca.DDD.infrastructure.repository.JpaProductoRepository;
import co.unicauca.DDD.ui.controller.CategoriaController;
import co.unicauca.DDD.ui.controller.ProductoController;

public class DddApplication {

	public static void main(String[] args) {
		//Repositorio de productos
		JpaProductoRepository productoRepository = new JpaProductoRepository();

		//Repositorio de categorías
		JpaCategoriaRepository categoriaRepository = new JpaCategoriaRepository();

		//Servicio de dominio de productos
		ProductoDomainService pDService = new ProductoDomainService();

		//Servicio de dominio de categorías
		ClasificacionDomainService cDService = new ClasificacionDomainService();

		//Servicio de aplicación de productos
		ProductoService pService = new ProductoService(productoRepository, pDService);

		//Servicio de aplicación de categorías
		CategoriaService cService = new CategoriaService(categoriaRepository, cDService);

		//Controlador de productos
		ProductoController productoController = new ProductoController(pService);

		//Controlador de categorías
		CategoriaController categoriasController = new CategoriaController(cService);

		//Crear una categoría
		Categoria objCategoria1 = new Categoria(1L, "Abonos");

		//Crear dos productos producto
		Producto objProducto1 = new Producto(1L, "Abono Orgánico", objCategoria1, new Disponibilidad(true, 20), "Es orgánico");
		Producto objProducto2 = new Producto(2L, "Abono Químico", objCategoria1, new Disponibilidad(true, 15), "Es químico");

		//Guardar categorías y productos
		categoriasController.crearCategoria(objCategoria1);

		productoController.crearProducto(objProducto1);
		productoController.crearProducto(objProducto2);

		//Listar categorías
		List<Categoria> categoryList = categoriaRepository.buscarTodas();

		//Listar productos
		List<Producto> productList = productoRepository.buscarTodos();

		//Mostrar productos y categorías por consola
		System.out.println("Lista de productos y categorías antes de modificar la disponibilidad:");
		MostrarCategoriasyProductos(productList, categoryList);

		productoController.modificarDisponibilidadProducto(1L, new Disponibilidad(false, 0));
		System.out.println("------------------------------------------------------------------------");

		//Mostrar productos y categorías por consola
		System.out.println("Lista de productos y categorías después de modificar la disponibilidad:");
		MostrarCategoriasyProductos(productList, categoryList);
		





	}

	public static void MostrarCategoriasyProductos(List<Producto> productList, List<Categoria> categoryList)
	{
		for (Producto producto : productList) {
			System.out.println("Producto: " + producto.getNombre() + ", Categoría: " + producto.getCategoria().getNombre()
					+ ", Disponible: " + producto.getDisponibilidad().isDisponible()
					+ ", Cantidad Disponible: " + producto.getDisponibilidad().getStock());
		}

		for (Categoria categoria : categoryList) {
			System.out.println("Categoría: " + categoria.getNombre());
		}
	}

}
