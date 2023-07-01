package co.edu.unbosque.TiendaGenericabackend.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.TiendaGenericabackend.dao.UsuariosDAO;
import co.edu.unbosque.TiendaGenericabackend.model.Usuarios;

@RestController 
@CrossOrigin
@RequestMapping("usuarios")
public class UsuariosAPI {
	
	@Autowired 
	private UsuariosDAO usuariosDAO;
	@PostMapping("/guardar")
	public void guardar(@RequestBody Usuarios usuario) {
	usuariosDAO.save(usuario);
	}
	@GetMapping("/listar")
	public List<Usuarios> listar(){
	return usuariosDAO.findAll();
	}
	@GetMapping("/buscarUsuario/{id}")
	public Usuarios buscarUsuario(@PathVariable(value="id") Integer id){
		ArrayList<Usuarios> lista=(ArrayList<Usuarios>)listar();
		Usuarios usuarioreturn=new Usuarios();
		for(Usuarios usuario:lista) {
			if(usuario.getCedula_usuario()==id) {
				usuarioreturn=usuario;
			}
		}
	return usuarioreturn;
	}
	@GetMapping("/eliminar/{id}")
	public void eliminar(@PathVariable(value="id") Integer id) {		
		usuariosDAO.deleteById(id);
	}
	@GetMapping("/eliminarTodos")
	public void eliminarTodos() {
	usuariosDAO.deleteAll();
	}
	@PostMapping("/actualizar")
	public void actualizar(@RequestBody Usuarios usuario) {
		usuariosDAO.save(usuario);
	}
	
}
