package com.sv.microservicioa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sv.microservicioa.modelo.Facturas;
import com.sv.microservicioa.modelo.Ventas;

@Repository
public interface MicroserverArepository extends JpaRepository<Ventas, Integer>{
	
	
	//1. validar si ya existe
	@Query("select v from Ventas v where v.numerofactura = ?1")
	Facturas buscarSiYaExiste(Facturas facturas);
	 
	//2.Totalizar todos los subTotales de un lote de facturas
	@Query("select sum(t.subTotal) from totales t where t.impaga = 'false'")
	Double totalizarSubTotales();
	
	//buscar por nomina
	@Query("select v from Ventas v inner join Empresas e on v.empresasId = e.id where e.id = ?1")
	List<Ventas> findByNominas(Integer empresa);
	
	
	// A continuacion , querys para conocer el efectivo percibido de las formas de pago:
	@Query("select sum(v.totalaPagar) from Ventas v where v.formaPago = 'tarjeta' ")
	Double formaPagoTarjeta();
	
	@Query("select sum(v.totalaPagar) from Ventas v where v.formaPago = 'credito' ")
	Double formaPagoCredito();
	
	@Query("select sum(v.totalaPagar) from Ventas v where v.formaPago = 'contado' ")
	Double formaPagoContado();
	
	@Query("select sum(v.totalaPagar) from Ventas v where v.formaPago = 'cheque' ")
	Double formaPagoCheque();
	 
}
