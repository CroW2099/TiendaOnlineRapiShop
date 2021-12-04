package idat.edu.pe.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.edu.pe.daa2.jpa.modelo.Productos;
import idat.edu.pe.daa2.jpa.servicios.ProductosServicio;

@RestController
@RequestMapping("/rest/Productos")
public class ProductosRestController {
	
	@Autowired
	private ProductosServicio servicio;

	@GetMapping
	public ResponseEntity<Object> buscartTodo() {

		List<Productos> listaProductos = servicio.buscarTodo();
		return new ResponseEntity<>(listaProductos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
		Productos productos = servicio.buscarPorID(id);
		if (productos == null)

			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Producto no encontrado,id porporcionado no es correcto");
		return new ResponseEntity<Object>(productos, HttpStatus.OK);

	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> crear(@RequestBody Productos productos) {
		servicio.crear(productos);
		return new ResponseEntity<Object>("Producto creado correctamente", HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Productos productos) {
		servicio.actualizar(productos);
		return new ResponseEntity<Object>("Producto actualizado correctamente", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> borrar(@PathVariable("id") int id) {
		servicio.borrarPorID(id);
		return new ResponseEntity<Object>("Producto eliminado correctamente", HttpStatus.OK);

	}

}
