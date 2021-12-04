package idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Productos;

public interface ProductosRepositorio extends CrudRepository<Productos, Integer> {

	@Query(value = "SELECT a FROM Productos a WHERE a.pro_nom = ?1")
	public List<Productos> buscarProductosPorNombre(String pro_nom);

	@Query(value = "SELECT a FROM Productos a WHERE a.pro_nom like CONCAT(?1, '%')")
	public List<Productos> buscarProductosLikeNombre(String pro_nom);
	

}
