package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Productos;
import idat.edu.pe.daa2.jpa.servicios.ProductosServicio;

@Controller
@RequestMapping("/Productos")
public class ProductosWebController {

	@Autowired
	private ProductosServicio servicio;

	@RequestMapping("/listarTodo")
	public String listarProductos(Model model) {
		List<Productos> listaProductos = servicio.buscarTodo();
		model.addAttribute("listaProductos", listaProductos);
		return "/moduloProductos/listarTodo";
	}

	@RequestMapping("/nuevo")
	public String nuevoProducto(Model model) {
		Productos productos = new Productos();
		model.addAttribute("Productos", productos);		
		return "/moduloProductos/nuevoProducto";
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearProducto(@ModelAttribute("Productos") Productos productos) {
		 servicio.crear(productos);
	    return "redirect:/Productos/listarTodo";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarProductos(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloProductos/editarProductos");
	    Productos productos = servicio.buscarPorID(id);
	    mav.addObject("Productos", productos);
	    return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarProductos(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
	    return "redirect:/Productos/listarTodo";       
	}

}
