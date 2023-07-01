package co.edu.unbosque.TiendaGenericabackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.TiendaGenericabackend.model.Proveedores;

@Repository
public interface ProveedoresDAO extends JpaRepository<Proveedores, Integer>{

}
