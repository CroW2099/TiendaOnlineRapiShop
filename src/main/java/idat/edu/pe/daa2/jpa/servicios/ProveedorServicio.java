package idat.edu.pe.daa2.jpa.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Proveedor;
import idat.edu.pe.daa2.jpa.repositorios.ProveedorRepositorio;

@Service
@Transactional
public class ProveedorServicio {

	@Autowired
	public ProveedorRepositorio repositorio;

	public ProveedorServicio() {

	}

	public Proveedor crear(Proveedor proveedor) {
		return repositorio.save(proveedor);
	}

	public List<Proveedor> buscarTodo() {
		return (ArrayList<Proveedor>) repositorio.findAll();
	}

	public Proveedor actualizar(Proveedor proveedorActualizar) {
		Proveedor proveedorActual = repositorio.findById(proveedorActualizar.getprov_id()).get();
		proveedorActual.setprov_id(proveedorActualizar.getprov_id());
		proveedorActual.setprov_nom(proveedorActualizar.getprov_nom());
		proveedorActual.setprov_dir(proveedorActualizar.getprov_dir());
		proveedorActual.setprov_cel(proveedorActualizar.getprov_cel());
		proveedorActual.setprov_email(proveedorActualizar.getprov_email());
		Proveedor proveedorActualizado = repositorio.save(proveedorActual);
		return proveedorActualizado;
	}

	public Proveedor buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

	public void actualizar(int id, Proveedor proveedor) {
		// TODO Auto-generated method stub
		Proveedor proveedorActual = repositorio.findById(id).get();
		proveedorActual.setprov_nom(proveedor.getprov_nom());
		proveedorActual.setprov_dir(proveedor.getprov_dir());
		proveedorActual.setprov_cel(proveedor.getprov_cel());
		proveedorActual.setprov_email(proveedor.getprov_email());
		 repositorio.save(proveedorActual);
		
	}
}