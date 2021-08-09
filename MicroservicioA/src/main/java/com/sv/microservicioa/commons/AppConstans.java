package com.sv.microservicioa.commons;

public class AppConstans {

	private AppConstans() {
		super();
	}
	//ERRORES DE SERVICIOS
	public static final String ERROR_FECHA_MSG= "mensaje.fecha.vacio";
	public static final String ERROR_IDEMPRESA_MSG= "mensaje.idempresa.vacio";
	public static final String ERROR_FACTURA_MSG= "mensaje.numfactura.vacio";
	public static final String ERROR_FECHAVENTA_MSG= "mensaje.fechaventa.vacio";
	public static final String ERROR_FECHAPAGO_MSG= "mensaje.fechapago.vacio";
	public static final String ERROR_IMPAGA_MSG= "mensaje.impaga.vacio";
	public static final String ERROR_IMPRESA_MSG= "mensaje.impresa.vacio";
	public static final String ERROR_FORMAPAGO_MSG= "mensaje.formapago.vacio";
	public static final String ERROR_TIPOFACTURA_MSG= "mensaje.tipofactura.vacio";
	public static final String ERROR_SUBTOTAL_MSG= "mensaje.subtotal.vacio";
	public static final String ERROR_IVA_MSG= "mensaje.iva.vacio";
	public static final String ERROR_CESC_MSG= "mensaje.cesc.vacio";
	public static final String ERROR_DESCUENTOS_MSG= "mensaje.descuentos.vacio";
	public static final String ERROR_TOTAL_MSG= "mensaje.total.vacio";
	
	public static final String ERROR_GUARDAR_MSG= "mensaje.guardar";
	public static final String ERROR_SUBTOTALLIST_MSG="mensaje.subtotal";
	public static final String ERROR_SUBTOTALLISTSERVICE_MSG="mensaje.subtotal.service";
	

	//CODIGOS DE ERRORES
	public static final String ERROR_SERVICIOSAVE_COD= "cod.servicio.ingresar";
	public static final String ERROR_CAMPOVACIO_COD= "cod.campo.vacio";
}
