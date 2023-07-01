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
import co.edu.unbosque.TiendaGenericabackend.dao.ProveedoresDAO;
import co.edu.unbosque.TiendaGenericabackend.model.Proveedores;

@RestController
@CrossOrigin
@RequestMapping("proveedores")
public class ProveedoresAPI {
	@Autowired
	private ProveedoresDAO proveedoresDAO;
	@PostMapping("/guardar")
	public void guardar(@RequestBody Proveedores proveedor) {
		proveedoresDAO.save(proveedor);
	}
	@GetMapping("/listar")
	public List<Proveedores> listar(){
	return proveedoresDAO.findAll();
	}
	@GetMapping("/buscarporID/{id}")
	public Proveedores buscarporID(@PathVariable(value="id") Integer id){
		List<Proveedores> lista=listar();
		Proveedores proveedorreturn=new Proveedores();
		for(Proveedores proveedor:lista) {
			if(proveedor.getNitproveedor()==id) {
				proveedorreturn=proveedor;
			}
		}
	return proveedorreturn;
	}
	@GetMapping("/eliminar/{id}")
	public void eliminar(@PathVariable(value="id") Integer id) {		
		proveedoresDAO.deleteById(id);
	}
	@GetMapping("/eliminarTodos")
	public void eliminarTodos() {
		proveedoresDAO.deleteAll();
	}
	@PostMapping("/actualizar")
	public void actualizar(@RequestBody Proveedores proveedor) {
		proveedoresDAO.save(proveedor);
	}
}
