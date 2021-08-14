package com.sv.microservicioa.dto;

import java.io.Serializable;

public class GuardarDto implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	//Variables:
  private String fecha; 
  private Integer empresa; 
  private Integer factura; 
  private String fechaVenta;  
  private String fechaPago; 
  private String impaga; 
  private String impresa; 
  private String formaPago;
  private String tipoFactura;
  private Double subTotal; 
  private Double subTotaliva; 
  private Double subTotalcesc; 
  private Double subTotaldescuentos; 
  private Double totalaPagar;

  public GuardarDto(String fecha, Integer empresa, Integer factura, String fechaVenta, String fechaPago, String impaga,
			String impresa, String formaPago, String tipoFactura, Double subTotal, Double subTotaliva, Double subTotalcesc,
			Double subTotaldescuentos, Double totalaPagar) {
	super();
	this.fecha = fecha;
	this.empresa = empresa;
	this.factura = factura;
	this.fechaVenta = fechaVenta;
	this.fechaPago = fechaPago;
	this.impaga = impaga;
	this.impresa = impresa;
	this.formaPago = formaPago;
	this.tipoFactura = tipoFactura;
	this.subTotal = subTotal;
	this.subTotaliva = subTotaliva;
	this.subTotalcesc = subTotalcesc;
	this.subTotaldescuentos = subTotaldescuentos;
	this.totalaPagar = totalaPagar;
}


public GuardarDto() {
	super();
}


public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public Integer getEmpresa() {
	return empresa;
}
public void setEmpresa(Integer empresa) {
	this.empresa = empresa;
}
public Integer getFactura() {
	return factura;
}
public void setFactura(Integer factura) {
	this.factura = factura;
}
public String getFechaVenta() {
	return fechaVenta;
}
public void setFechaVenta(String fechaVenta) {
	this.fechaVenta = fechaVenta;
}
public String getFechaPago() {
	return fechaPago;
}
public void setFechaPago(String fechaPago) {
	this.fechaPago = fechaPago;
}
public String getImpaga() {
	return impaga;
}
public void setImpaga(String impaga) {
	this.impaga = impaga;
}
public String getImpresa() {
	return impresa;
}
public void setImpresa(String impresa) {
	this.impresa = impresa;
}
public String getFormaPago() {
	return formaPago;
}
public void setFormaPago(String formaPago) {
	this.formaPago = formaPago;
}
public String getTipoFactura() {
	return tipoFactura;
}
public void setTipoFactura(String tipoFactura) {
	this.tipoFactura = tipoFactura;
}
public Double getSubTotal() {
	return subTotal;
}
public void setSubTotal(Double subTotal) {
	this.subTotal = subTotal;
}
public Double getSubTotaliva() {
	return subTotaliva;
}
public void setSubTotaliva(Double subTotaliva) {
	this.subTotaliva = subTotaliva;
}
public Double getSubTotalcesc() {
	return subTotalcesc;
}
public void setSubTotalcesc(Double subTotalcesc) {
	this.subTotalcesc = subTotalcesc;
}
public Double getSubTotaldescuentos() {
	return subTotaldescuentos;
}
public void setSubTotaldescuentos(Double subTotaldescuentos) {
	this.subTotaldescuentos = subTotaldescuentos;
}
public Double getTotalaPagar() {
	return totalaPagar;
}
public void setTotalaPagar(Double totalaPagar) {
	this.totalaPagar = totalaPagar;
}
  
  
}
