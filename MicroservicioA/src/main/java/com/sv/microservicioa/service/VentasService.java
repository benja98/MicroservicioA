package com.sv.microservicioa.service;

import java.util.List;

import javax.persistence.EntityManager;

import java.security.GuardedObject;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.sv.microservicioa.commons.AppConstans;
import com.sv.microservicioa.dto.EditarDto;
import com.sv.microservicioa.dto.GuardarDto;
import com.sv.microservicioa.dto.ListDto;
import com.sv.microservicioa.modelo.Empresas;
import com.sv.microservicioa.modelo.Facturas;
import com.sv.microservicioa.modelo.Totales;
import com.sv.microservicioa.modelo.Ventas;
import com.sv.microservicioa.repository.EmpresasRepository;
import com.sv.microservicioa.repository.TotalesRepository;
import com.sv.microservicioa.repository.VentasRepository;
import com.sv.microservicioa.repository.FacturasRepository;
import com.sv.microservicioa.repository.GuardarRepository;
import com.sv.microservicioa.util.DatosNoEncontradosException;

@Service
public class VentasService {
	// inyeccion
	@Autowired
	private Environment env;
	@Autowired
	VentasRepository ventasrepository;
	@Autowired
	TotalesRepository totalesrepository;
	@Autowired
	EmpresasRepository empresasrepository;
	@Autowired
	FacturasRepository facturaspository;
	@Autowired
	GuardarRepository guardarepository;

/////////////////-------------------metodo para guardar------/////////////////////////////////////////////////////////////////////
		public ListDto saveUserList(ListDto vdto) {
			ListDto savedList = new ListDto();
			try {
				 //declaramos lista a retornar
//				List<VentasDto> response = new ArrayList<>();
			   System.out.println(vdto.getDatosList());
			      //iteramos resultado
			          for (GuardarDto objeto : vdto.getDatosList()) {	
			        	  //primer crear total
			        	  Totales p = new Totales();
			        	  p.setFechapago(objeto.getFechaPago());
			        	  p.setImpaga(objeto.getImpaga());
			        	  p.setFormaPago(objeto.getFormaPago());
			        	  p.setSubTotal(objeto.getSubTotal());
			        	  p.setSubtoTaliva(objeto.getSubTotaliva());
			        	  p.setSubTotalcesc(objeto.getSubTotalcesc());
			        	  p.setSubTotaldescuentos(objeto.getSubTotaldescuentos());
			        	  p.setTotalaPagar(objeto.getTotalaPagar());
			        	  totalesrepository.save(p);
			        	  
			        	  //crear factura y a factura meter total
			        	  Facturas f = new Facturas();
			        	  f.setNumeroFactura(objeto.getFactura());
			        	  f.setImpresa(objeto.getImpresa());
			        	  f.setTipoFactura(objeto.getTipoFactura());
			        	  f.setTotalesId(p);
			        	  
			        	  facturaspository.save(f);
			        	  //crear empresa
			        	  Empresas e = new Empresas();
			        	  e.setId(objeto.getEmpresa());
			        	  //crear venta, meter empresa a venta y meter factura a venta
			        	  Ventas v = new Ventas();
			        	  v.setFecha(objeto.getFecha());
			        	  v.setFechaVenta(objeto.getFechaVenta());
			        	  v.setEmpresasId(e);
			        	  v.setFactura(f);
			        	  
			        	  ventasrepository.save(v);
			        	  
			          }
			}
			catch (DatosNoEncontradosException exc ) {
				throw exc;
			  		}catch (Exception e) {
			  			e.printStackTrace();
						throw new DatosNoEncontradosException("409", "Error en el servicio guardar");
			  		}
				return savedList; 
		}
		

	

/////////////////-------------------metodo para editar------/////////////////////////////////////////////////////////////////////

	public void EditarVentas(EditarDto dto) {
		try {
			
				Ventas venta = ventasrepository.buscarSiYaExiste(dto.getNumeroFacturas());
				if (venta != null) {
					Empresas empresas = empresasrepository.buscarid(dto.getIdEmpresa());
					
						if(empresas != null){
						venta.setEmpresasId(empresas);
						venta.setFecha(dto.getFecha());
						ventasrepository.save(venta);
					
						}
						throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
								env.getProperty(AppConstans.ERROR_BUSCAREMP_MSG));
				}
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
						env.getProperty(AppConstans.ERROR_EDITAR_MSG));
			}catch (DatosNoEncontradosException exc ) {
				throw exc;
			}catch (Exception e) 
			{
				e.printStackTrace();
				throw new DatosNoEncontradosException("409", "Error en el servicio eliminar");
			}
		} // fin del metodo guardar
	

/////////////////-------------------metodo para eliminar nomina por factura------/////////////////////////////////////////////////////////////////////
	
	
	
	
	public void delete (Integer facturas) {
		try {
			if(facturas <= 0 || facturas == null ) {
			throw new DatosNoEncontradosException("ERROR NUMERO FACTURA NO VALIDO ");
		}
			
			Ventas venta = ventasrepository.buscarSiYaExiste(facturas);
			
			if (venta != null) {
				ventasrepository.delete(venta);
			} 
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
			env.getProperty(AppConstans.ERROR_BORRAR_MSG));
			}catch (DatosNoEncontradosException exc ) {
				throw exc;
			}catch (Exception e) {
				e.printStackTrace();
				throw new DatosNoEncontradosException("409", "Error en el servicio eliminar");
			}
		}

	
/////////////////-------------------Metodo para sumar los SubTotales------/////////////////////////////////////////////////////////////////////

	
	
	
	public Double totalizarSubT() {
		Double lv = null;
		 
		try {
			lv = totalesrepository.totalizarSubTotales();
			
			if(lv <= 0) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
						env.getProperty(AppConstans.ERROR_SUBTOTALLIST_MSG));
			} 
		}catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio totalizar subtotales");
		}
		return lv; 
	}
	
	
	//continuacion del metodo totalizarSubT
	

	
	
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
			 
		}catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio imprimir calculos");
		}
		return "Subtotal: $" + totalizarSubT() + " , Iva: $" + totalIva +
				" , Cesc: $" + totalCesc + ", Utilidades: $" + utilidades + " , Total: $" + total;  
		
	}  // fin del metodo imprimir calculos de ley.
	
	
	//Metodo para imprimir el efectivo percibido de los tipos de pago:
	
	
	
	
	public String imprimirEfectivoPercibido() { 
		// Instanciando nuestras querys personalizadas:
		double cheque=0.00;
		double contado=0.00;
		double credito=0.00;
		double tarjeta=0.00;
		
		try {
			cheque = totalesrepository.formaPagoCheque(); 
			contado =totalesrepository.formaPagoContado(); 
			credito = totalesrepository.formaPagoCredito(); 
			tarjeta = totalesrepository.formaPagoTarjeta();
			 	
		}catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio imprimir efectivo persivido");
		}
		return "Efectivo percibido con CHEQUE es de : $" + cheque + ", CONTADO : $" +contado + ", CREDITO : $"+credito + ", TARJETA: $"+tarjeta; 
		
	}
}
