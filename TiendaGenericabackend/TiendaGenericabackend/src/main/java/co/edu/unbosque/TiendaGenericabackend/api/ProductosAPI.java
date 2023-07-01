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

import co.edu.unbosque.TiendaGenericabackend.dao.ProductosDAO;
import co.edu.unbosque.TiendaGenericabackend.model.Productos;

@RestController
@CrossOrigin
@RequestMapping("productos")
public class ProductosAPI {
	
	@Autowired
	private ProductosDAO productosDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Productos producto) {
		productosDAO.save(producto);
	}
	@GetMapping("/listar")
	public List<Productos> listar(){
	return productosDAO.findAll();
	}
	@GetMapping("/buscarporID/{id}")
	public Productos buscarporId(@PathVariable(value="id") Integer id){
		List<Productos> lista=listar();
		Productos productoreturn=new Productos();
		for(Productos producto:lista) {
			if(producto.getCodigo_producto()==id) {
				productoreturn=producto;
			}
		}
	return productoreturn;
	}
	@GetMapping("/eliminar/{id}")
	public void eliminar(@PathVariable(value="id") Integer id) {		
		productosDAO.deleteById(id);
	}
	@GetMapping("/eliminarTodos")
	public void eliminarTodos() {
		productosDAO.deleteAll();
	}
	@PostMapping("/actualizar")
	public void actualizar(@RequestBody Productos producto) {
		productosDAO.save(producto);
	}

}
