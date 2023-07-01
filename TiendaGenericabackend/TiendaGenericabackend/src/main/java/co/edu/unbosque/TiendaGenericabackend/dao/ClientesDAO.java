package co.edu.unbosque.TiendaGenericabackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.TiendaGenericabackend.model.Clientes;

@Repository
public interface ClientesDAO extends JpaRepository<Clientes, Integer>{

}
