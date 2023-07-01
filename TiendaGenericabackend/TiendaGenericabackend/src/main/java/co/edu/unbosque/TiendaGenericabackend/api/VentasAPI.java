package co.edu.unbosque.TiendaGenericabackend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.TiendaGenericabackend.dao.VentasDAO;
import co.edu.unbosque.TiendaGenericabackend.model.Ventas;

@RestController
@CrossOrigin
@RequestMapping("ventas")
public class VentasAPI {
	@Autowired
	private VentasDAO ventasDAO;
	@PostMapping("/guardar")
	public void guardar(@RequestBody Ventas venta) {
		ventasDAO.save(venta);
	}
	@GetMapping("/listar")
	public List<Ventas> listar(){
	return ventasDAO.findAll();
	}
	@GetMapping("/buscarporID/{id}")
	public Ventas buscarporID(@PathVariable(value="id") Integer id){
		List<Ventas> lista=listar();
		Ventas ventareturn=new Ventas();
		for(Ventas venta:lista) {
			if(venta.getCodigo_venta()==id) {
				ventareturn=venta;
			}
		}
	return ventareturn;
	}
	@GetMapping("/eliminar/{id}")
	public void eliminar(@PathVariable(value="id") Integer id) {		
		ventasDAO.deleteById(id);
	}
	@GetMapping("/eliminarTodos")
	public void eliminarTodos() {
		ventasDAO.deleteAll();
	}
	@PostMapping("/actualizar")
	public void actualizar(@RequestBody Ventas venta) {
		ventasDAO.save(venta);
	}

}
