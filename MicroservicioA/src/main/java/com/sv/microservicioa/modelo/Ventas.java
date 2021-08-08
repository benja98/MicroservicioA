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
    @JoinColumn(name="empresasid" , referencedColumnName= "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresas empresasId;
    
    @Column(name="factura")
    private int factura;
    
    @Column(name="fechaventa")
    private String fechaVenta;
    
    @Column(name="fechapago")  
    private String fechaPago;
    
    @Column(name="impaga")
    private String impaga;
    
    @Column(name="impresa")
    private String impresa;
    
    @Column(name="formapago")
    private String formaPago;
    
    @Column(name="tipofactura")
    private String tipoFactura;
    
    @Column(name="subtotal")
    private Double subTotal;
    
    @Column(name="subtotaliva")
    private Double subTotalIva;
    
    @Column(name="subtotalcesc")
    private Double subTotalCesc;
    
    @Column(name="subtotaldescuentos")
    private Double subTotalDescuentos;
    
    @Column(name="totalapagar")
    private Double totalaPagar;

 

    
    //CONSTRUCTORES
    
    
    public Ventas(int id, String fecha, Empresas empresasId, int factura, String fechaVenta, String fechaPago, String impaga,
            String impresa, String formaPago, String tipoFactura, Double subTotal, Double subTotalIva,
            Double subTotalCesc, Double subTotalDescuentos, Double totalaPagar) {
        super();
        this.id = id;
        this.fecha = fecha;
        this.empresasId = empresasId;
        this.factura = factura;
        this.fechaVenta = fechaVenta;
        this.fechaPago = fechaPago;
        this.impaga = impaga;
        this.impresa = impresa;
        this.formaPago = formaPago;
        this.tipoFactura = tipoFactura;
        this.subTotal = subTotal;
        this.subTotalIva = subTotalIva;
        this.subTotalCesc = subTotalCesc;
        this.subTotalDescuentos = subTotalDescuentos;
        this.totalaPagar = totalaPagar;
    }

 


    public Ventas() {
        super();
    }

 

    
    //GET Y SET

 

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

 


    public Empresas getEmpresasId() {
        return empresasId;
    }

 


    public void setEmpresasId(Empresas empresasId) {
        this.empresasId = empresasId;
    }

 


    public int getFactura() {
        return factura;
    }

 


    public void setFactura(int factura) {
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

 


    public Double getSubTotalIva() {
        return subTotalIva;
    }

 


    public void setSubTotalIva(Double subTotalIva) {
        this.subTotalIva = subTotalIva;
    }

 


    public Double getSubTotalCesc() {
        return subTotalCesc;
    }

 


    public void setSubTotalCesc(Double subTotalCesc) {
        this.subTotalCesc = subTotalCesc;
    }

 


    public Double getSubTotalDescuentos() {
        return subTotalDescuentos;
    }

 


    public void setSubTotalDescuentos(Double subTotalDescuentos) {
        this.subTotalDescuentos = subTotalDescuentos;
    }




	public Double getTotalaPagar() {
		return totalaPagar;
	}




	public void setTotalaPagar(Double totalaPagar) {
		this.totalaPagar = totalaPagar;
	}

 


 
    
    
}
