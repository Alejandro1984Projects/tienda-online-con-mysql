package co.edu.unbosque.TiendaGenericabackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.TiendaGenericabackend.model.Ventas;

@Repository
public interface VentasDAO extends JpaRepository<Ventas, Integer>{

}
