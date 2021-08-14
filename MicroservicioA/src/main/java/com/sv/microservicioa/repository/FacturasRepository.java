package com.sv.microservicioa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sv.microservicioa.modelo.Facturas;
import com.sv.microservicioa.modelo.Ventas;

public interface FacturasRepository extends JpaRepository<Facturas, Integer>{

	@Query(value = "SELECT v FROM Ventas v "
            + "JOIN FETCH v.empresa e "
            + "JOIN FETCH v.factura f "
            + "JOIN FETCH f.totalesId t "
            + "where f.numeroFactura = ?1 ")
	Facturas buscarexistencia(Integer id);
}
