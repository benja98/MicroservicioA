package com.sv.microservicioa.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.microservicioa.dto.VentasDto;
import com.sv.microservicioa.modelo.Empresas;
import com.sv.microservicioa.modelo.Ventas;
import com.sv.microservicioa.repository.VentasRepository;
import com.sv.microservicioa.util.DatosNoEncontradosException;

@Service
public class VentasService {

	// inyeccion
	@Autowired
	private VentasRepository vR;

	
	
	// metodo para guardar:
	public void guardarVentas(VentasDto vdto) {

		try {
			
			//1. Respectivas validaciones:

			/*
			if (vdto.getFecha() == null) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getEmpresasId() <= 0) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getFactura() <= 0) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getFechaVenta() == null) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO VACIO");
			}
			if (vdto.getFechaPago() == null) {
				throw new DatosNoEncontradosException("400", "ERROR NCAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getImpaga() == null || vdto.getImpaga().isEmpty()) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getImpresa() == null || vdto.getImpresa().isEmpty()) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getFormaPago() == null || vdto.getFormaPago().isEmpty()) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getTipoFactura() == null || vdto.getTipoFactura().isEmpty()) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getSubTotal() == null || vdto.getSubTotal() <= 0) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getSubTotalIva() == null || vdto.getSubTotalIva() <= 0) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getSubTotalCesc() == null || vdto.getSubTotalCesc() <= 0) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getSubTotalDescuentos() == null || vdto.getSubTotalDescuentos() <= 0) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			if (vdto.getTotalaPagar() == null || vdto.getTotalaPagar() <= 0) {
				throw new DatosNoEncontradosException("400", "ERROR CAMPO NO PEDE QUEDAR VACIO");
			}
			*/
			
			
			
			//2. Instanciando mi entity para setiarla con los datos de la Dto:
			Ventas v = new Ventas();
			v.setId(vdto.getId());
			v.setFecha(vdto.getFecha());
			 
			// mandando a llamar la clase para setiar objeto(LLAVE FORANEA)
			Empresas e = new Empresas();
			e.setId(vdto.getEmpresasId());
			v.setEmpresasId(e);
			
			v.setFactura(vdto.getFactura());
			/*
			// convertir String a Date: FECHA DE LA VENTA
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	        Date fechaDate = null;
	        fechaDate = formato.parse(vdto.getFechaVenta()); 
			v.setFechaVenta(fechaDate); */ 
			v.setFechaVenta(vdto.getFechaVenta());
			/*
			//Convertir String a Date : FECHA DE PAGO
			SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
	        Date fechaDate2 = null;
	        fechaDate2 = formato1.parse(vdto.getFechaPago()); 
			v.setFechaPago(fechaDate2);  
			*/
			v.setFechaPago(vdto.getFechaPago()); 
			v.setImpaga(vdto.getImpaga());
			v.setImpresa(vdto.getImpresa());
			v.setFormaPago(vdto.getFormaPago());
			v.setTipoFactura(vdto.getTipoFactura());
			v.setSubTotal(vdto.getSubTotal());
			v.setSubTotalIva(vdto.getSubTotalIva());
			v.setSubTotalCesc(vdto.getSubTotalCesc());
			v.setSubTotalDescuentos(vdto.getSubTotalDescuentos());
			v.setTotalaPagar(vdto.getTotalaPagar());
 
			
			if(v.getFactura() != 0) {
				Ventas vv = vR.buscarSiYaExiste(v.getFactura());
				
				if(vv != null) {
					System.out.println("No se puede guardar porque ese registro ya existe, si deseas editarlo acude al metodo correspondiente");
				}else {
					vR.save(v);
				} 
			}
			 
			 
		} catch (DatosNoEncontradosException exc) {
			throw exc;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio ingresar datos");
		} 
	} // fin del metodo guardar
	
	
	
	 
	// metodo para traer la suma de los subtotales
	public List<Ventas> totalizarSubT(){
		List<Ventas> lv = null;
		
		lv = vR.totalizarSubTotales();
		return lv;
	}
	 
	
	 
	
	

}
