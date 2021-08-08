package com.sv.microservicioa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sv.microservicioa.modelo.Ventas;


@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer>{
	
	
	//1. validar si ya existe
	@Query("select v from Ventas v where v.factura = ?1")
	Ventas buscarSiYaExiste(int factura);
	 
	//2.Totalizar todos los subTotales de un lote de facturas
	@Query("select v , sum(v.subTotal) from Ventas v GROUP BY v.fecha")
	List<Ventas> totalizarSubTotales();
 
	 
}
