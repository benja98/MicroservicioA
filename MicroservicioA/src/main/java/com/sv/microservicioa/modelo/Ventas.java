package com.sv.microservicioa.modelo;

import java.io.Serializable;
import java.util.Date; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

 

@Entity
@Table(name= "ventas")
public class Ventas implements Serializable{

 

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="fecha") 
    private String fecha;
    
    //@Column(name="empresasid") 
    @JoinColumn(name="empresa" , referencedColumnName= "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresas empresa;
    
    @JoinColumn(name="factura", referencedColumnName= "numerofactura")
    @ManyToOne(fetch = FetchType.LAZY)
    private Facturas factura;
    
    @Column(name="fechaventa")
    private String fechaVenta;

	public Ventas(int id, String fecha, Empresas empresa, Facturas factura, String fechaVenta) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.empresa = empresa;
		this.factura = factura;
		this.fechaVenta = fechaVenta;
	}

	public Ventas() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresasId(Empresas empresa) {
		this.empresa = empresa;
	}

	public Facturas getFactura() {
		return factura;
	}

	public void setFactura(Facturas factura) {
		this.factura = factura;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

    
}
