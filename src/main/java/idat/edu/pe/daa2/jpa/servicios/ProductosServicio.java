package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Productos;
import idat.edu.pe.daa2.jpa.repositorios.ProductosRepositorio;


@Service
@Transactional
public class ProductosServicio {
	@Autowired
	private ProductosRepositorio repositorio;

	public ProductosServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Productos> buscarTodo() {
		return (List<Productos>) repositorio.findAll();  
	}

	public Productos crear(Productos productos) {
		return repositorio.save(productos);
	}

	public Productos actualizar(Productos productosActualizar) {
		Productos productosActual = repositorio.findById(productosActualizar.getpro_id()).get();
		productosActual.setpro_id(productosActualizar.getpro_id());
		productosActual.setpro_nom(productosActualizar.getpro_nom());
		productosActual.setpro_desc(productosActualizar.getpro_desc());
		productosActual.setpro_cant(productosActualizar.getpro_cant());
		productosActual.setpro_prec(productosActualizar.getpro_prec());
		productosActual.setpro_stock(productosActualizar.getpro_stock());
		productosActual.setpro_enorden(productosActualizar.getpro_enorden());
		productosActual.setProveedor(productosActualizar.getProveedor());
		productosActual.setCategoria(productosActualizar.getCategoria());
		Productos productosActualizado = repositorio.save(productosActual);
		return productosActualizado;
	}

	public Productos buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
