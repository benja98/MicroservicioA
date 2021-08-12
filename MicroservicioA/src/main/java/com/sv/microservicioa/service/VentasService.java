package com.sv.microservicioa.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.sv.microservicioa.commons.AppConstans;
import com.sv.microservicioa.dto.VentasDto;
import com.sv.microservicioa.modelo.Facturas;
import com.sv.microservicioa.modelo.Ventas;
import com.sv.microservicioa.repository.MicroserverArepository;
import com.sv.microservicioa.util.DatosNoEncontradosException;

@Service
public class VentasService {

	// inyeccion
	@Autowired
	private Environment env;
	@Autowired
	private MicroserverArepository MAR;

	
	// 1. metodo para guardar:
	public String saveUserList(List<VentasDto> vdto) {
		List<VentasDto> saveList = new ArrayList<>();
		MAR.saveAll(vdto).forEach(saveList::add);
		return "guardando facturas " + saveList.stream().map(u->u.getFactura()).collect(Collectors.toList());
	}
	

//	
//	//metodo para editar
//	public void EditarVentas(VentasDto vdto) {
//		try {
//			// 1. Respectivas validaciones:
//			if (vdto.getFecha() == null) {
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_FECHA_MSG));
//					
//			} if (vdto.getEmpresasId() <= 0){
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_IDEMPRESA_MSG));
//					
//			} if (vdto.getFactura() <= 0) { 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_FACTURA_MSG));
//					
//			} if (vdto.getFechaVenta() == null) {
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_FECHAVENTA_MSG));
//				
//			} if (vdto.getFechaPago() == null){
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_FECHAPAGO_MSG));
//					
//			} if (vdto.getImpaga() == null ||vdto.getImpaga().isEmpty()){ 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_IMPAGA_MSG));
//					
//			} if (vdto.getImpresa() == null ||vdto.getImpresa().isEmpty()) {
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_IMPRESA_MSG));
//					
//			} if (vdto.getFormaPago() == null ||vdto.getFormaPago().isEmpty()){ 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_FORMAPAGO_MSG));
//				
//			} if (vdto.getTipoFactura() == null ||vdto.getTipoFactura().isEmpty()){ 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_TIPOFACTURA_MSG));
//					
//			} if(vdto.getSubTotal() == null || vdto.getSubTotal() <= 0){ 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_SUBTOTAL_MSG));
//					
//			} if(vdto.getSubTotalIva() == null || vdto.getSubTotalIva() <= 0) {
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_IVA_MSG));
//					
//			} if(vdto.getSubTotalCesc() == null || vdto.getSubTotalCesc() <= 0) { 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_CESC_MSG));
//				
//			} if(vdto.getSubTotalDescuentos() == null || vdto.getSubTotalDescuentos() <= 0) {
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_DESCUENTOS_MSG));
//					
//			} if (vdto.getTotalaPagar() == null ||vdto.getTotalaPagar() <= 0) { 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_TOTAL_MSG));
//			}
//			if (vdto.getFecha() == null) {
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_FECHA_MSG));
//					
//			} if (vdto.getEmpresasId() <= 0){
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_IDEMPRESA_MSG));
//					
//			} if (vdto.getFactura() <= 0) { 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_FACTURA_MSG));
//					
//			} if (vdto.getFechaVenta() == null) {
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_FECHAVENTA_MSG));
//				
//			} if (vdto.getFechaPago() == null){
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_FECHAPAGO_MSG));
//					
//			} if (vdto.getImpaga() == null ||vdto.getImpaga().isEmpty()){ 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_IMPAGA_MSG));
//					
//			} if (vdto.getImpresa() == null ||vdto.getImpresa().isEmpty()) {
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_IMPRESA_MSG));
//					
//			} if (vdto.getFormaPago() == null ||vdto.getFormaPago().isEmpty()){ 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_FORMAPAGO_MSG));
//				
//			} if (vdto.getTipoFactura() == null ||vdto.getTipoFactura().isEmpty()){ 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_TIPOFACTURA_MSG));
//					
//			} if(vdto.getSubTotal() == null || vdto.getSubTotal() <= 0){ 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_SUBTOTAL_MSG));
//					
//			} if(vdto.getSubTotalIva() == null || vdto.getSubTotalIva() <= 0) {
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_IVA_MSG));
//					
//			} if(vdto.getSubTotalCesc() == null || vdto.getSubTotalCesc() <= 0) { 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_CESC_MSG));
//				
//			} if(vdto.getSubTotalDescuentos() == null || vdto.getSubTotalDescuentos() <= 0) {
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_DESCUENTOS_MSG));
//					
//			} if (vdto.getTotalaPagar() == null ||vdto.getTotalaPagar() <= 0) { 
//				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
//						env.getProperty(AppConstans.ERROR_TOTAL_MSG));
//			}
//				
//
//			// 2. Instanciando mi entity para setiarla con los datos de la Dto:
//			Ventas v = new Ventas();
//			Empresas e = new Empresas();
//			Facturas f = new Facturas();
//			Totales p = new Totales();
//			
//			v.setFecha(vdto.getFecha());
//			e.setId(vdto.getEmpresa());
//			v.setEmpresasId(e);
//			f.setNumeroFactura(vdto.getFactura());
//			v.setFactura(f);
//			v.setFechaVenta(vdto.getFechaVenta());
//			p.setFechapago(vdto.getFechaPago());
//			p.setImpaga(vdto.getImpaga());
//			f.setImpresa(vdto.getImpresa());
//			p.setFormaPago(vdto.getFechaPago());
//			f.setTipoFactura(vdto.getTipoFactura());
//			p.setSubTotal(vdto.getSubTotal());
//			p.setSubtoTaliva(vdto.getSubTotalIva());
//			p.setSubTotalcesc(vdto.getSubTotalCesc());
//			p.setSubTotaldescuentos(vdto.getSubTotalDescuentos());
//			p.setTotalaPagar(vdto.getTotalaPagar());
//			v.setId(vdto.getId());
//			v.setFecha(vdto.getFecha());
//
//			// mandando a llamar la clase para setiar objeto(LLAVE FORANEA)
//			Empresas e = new Empresas();
//			e.setId(vdto.getEmpresasId());
//			v.setEmpresasId(e);
//
//			v.setFactura(vdto.getFactura());
//			v.setFechaVenta(vdto.getFechaVenta());
//			v.setFechaPago(vdto.getFechaPago());
//			v.setImpaga(vdto.getImpaga());
//			v.setImpresa(vdto.getImpresa());
//			v.setFormaPago(vdto.getFormaPago());
//			v.setTipoFactura(vdto.getTipoFactura());
//			v.setSubTotal(vdto.getSubTotal());
//			v.setSubTotalIva(vdto.getSubTotalIva());
//			v.setSubTotalCesc(vdto.getSubTotalCesc());
//			v.setSubTotalDescuentos(vdto.getSubTotalDescuentos());
//			v.setTotalaPagar(vdto.getTotalaPagar());
//			vR.save(v);
//			
//		} catch (DatosNoEncontradosException exc) {
//			throw exc;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new DatosNoEncontradosException("409", "Error en el servicio editar datos");
//		}
//	} // fin del metodo guardar
//	
	

	//metodo para eliminar nomina por factura 
	public void delete (Integer id) {
		try {
			if(id <= 0 || id == null ) {
			throw new DatosNoEncontradosException("ERROR EL ID NO EXISTE");
		}
			Ventas v = new Ventas();
			Facturas vv = MAR.buscarSiYaExiste(v.getFactura());

		if (vv != null) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
					env.getProperty(AppConstans.ERROR_GUARDAR_MSG));
		} else {
			MAR.deleteById(id);
		}
		MAR.deleteById(id);
		}catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio eliminar");
		}
	}

	
	

	//2.0 Metodo para sumar los SubTotales
	public Double totalizarSubT() {
		Double lv = null;
		 
		try {
			lv = MAR.totalizarSubTotales();
			
			if(lv <= 0) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
						env.getProperty(AppConstans.ERROR_SUBTOTALLIST_MSG));
			} 
		}catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_SUBTOTALLISTSERVICE_MSG));
		}
		return lv; 
	}
	
	
	// 2.1 continuacion del metodo totalizarSubT
	public String imprimirCalculos() {
		final double iva;
		double totalIva = 0.00;
		double totalCesc = 0.00;
		double total = 0.00;
		double cesc = 0.05;
		double utilidades = 0.00;
		try {
			 
			 iva = 0.13;
			 totalIva = totalizarSubT() * iva;
			 totalCesc = totalizarSubT() * cesc;
			 total = totalizarSubT() + totalIva + totalCesc;
			 utilidades = totalIva  + totalCesc;
			 
		}catch(Exception e) {
			e.printStackTrace();
		} 
		return "Subtotal: $" + totalizarSubT() + " , Iva: $" + totalIva +
				" , Cesc: $" + totalCesc + ", Utilidades: $" + utilidades + " , Total: $" + total;  
		
	}  // fin del metodo imprimir calculos de ley.
	
	
	
	
	// 3. Metodo para imprimir el efectivo percibido de los tipos de pago:
	public String imprimirEfectivoPercibido() { 
		// Instanciando nuestras querys personalizadas:
		double cheque=0.00;
		double contado=0.00;
		double credito=0.00;
		double tarjeta=0.00;
		
		try {
			cheque = MAR.formaPagoCheque(); 
			contado =MAR.formaPagoContado(); 
			credito = MAR.formaPagoCredito(); 
			tarjeta = MAR.formaPagoTarjeta();
			 	
		}catch(Exception e) {
			e.printStackTrace();
		} 
		return "Efectivo percibido con CHEQUE es de : $" + cheque + ", CONTADO : $" +contado + ", CREDITO : $"+credito + ", TARJETA: $"+tarjeta; 
		
	}
}
