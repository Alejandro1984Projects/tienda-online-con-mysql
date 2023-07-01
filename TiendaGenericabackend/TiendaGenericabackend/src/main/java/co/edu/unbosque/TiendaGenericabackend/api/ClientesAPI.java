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
import co.edu.unbosque.TiendaGenericabackend.dao.ClientesDAO;
import co.edu.unbosque.TiendaGenericabackend.model.Clientes;

@RestController
@CrossOrigin
@RequestMapping("clientes")
public class ClientesAPI {
		
		@Autowired
		private ClientesDAO clientesDAO;
		@PostMapping("/guardar")
		public void guardar(@RequestBody Clientes cliente) {
			clientesDAO.save(cliente);
		}
		@GetMapping("/listar")
		public List<Clientes> listar(){
		return clientesDAO.findAll();
		}
		@GetMapping("/buscarporID/{id}")
		public Clientes buscarporID(@PathVariable(value="id") Integer id){
			List<Clientes> lista=listar();
			Clientes clientereturn=new Clientes();
			for(Clientes cliente:lista) {
				if(cliente.getCedula_cliente()==id) {
					clientereturn=cliente;
				}
			}
		return clientereturn;
		}
		@GetMapping("/eliminar/{id}")
		public void eliminar(@PathVariable(value="id") Integer id) {		
			clientesDAO.deleteById(id);
		}
		@GetMapping("/eliminarTodos")
		public void eliminarTodos() {
			clientesDAO.deleteAll();
		}
		@PostMapping("/actualizar")
		public void actualizar(@RequestBody Clientes cliente) {
			clientesDAO.save(cliente);
		}
		
	}