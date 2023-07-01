package co.edu.unbosque.TiendaGenericabackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.TiendaGenericabackend.model.Usuarios;

@Repository
public interface UsuariosDAO extends JpaRepository<Usuarios, Integer>{
}
