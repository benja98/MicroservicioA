package com.sv.microservicioa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sv.microservicioa.dto.EditarDto;
import com.sv.microservicioa.modelo.Facturas;
import com.sv.microservicioa.modelo.Totales;
import com.sv.microservicioa.modelo.Ventas;

@Repository
public interface TotalesRepository extends JpaRepository<Totales, Integer>{
	 
	//1.Totalizar todos los subTotales de un lote de facturas
	@Query("select sum(t.subTotal) from Totales t where t.impaga = 'false'")
	Double totalizarSubTotales();
	
	// A continuacion , querys para conocer el efectivo percibido de las formas de pago:
	@Query("select sum(v.totalaPagar) from Totales v where v.formaPago = 'TARJETA' ")
	Double formaPagoTarjeta();
	
	@Query("select sum(v.totalaPagar) from Totales v where v.formaPago = 'CREDITO' ")
	Double formaPagoCredito();
	
	@Query("select sum(v.totalaPagar) from Totales v where v.formaPago = 'CONTADO' ")
	Double formaPagoContado();
	
	@Query("select sum(v.totalaPagar) from Totales v where v.formaPago = 'CHEQUE' ")
	Double formaPagoCheque();
	 
}
