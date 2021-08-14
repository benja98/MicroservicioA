package com.sv.microservicioa.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "totales")
public class Totales implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="id")
    private Integer id;
	
	@Column(name="impaga")
	private String impaga;
	    
    @Column(name="fechapago")
    private String fechapago;
    
    @Column(name="formapago")
    private String formaPago;
	
    @Column(name="subtotal")
    private Double subTotal;
    
    @Column(name="subtotaliva")
    private Double subtoTaliva;
    
    @Column(name="subtotalcesc")
    private Double subTotalcesc;
    
    @Column(name="subtotaldescuentos")
    private Double subTotaldescuentos;
    
    @Column(name="totalapagar")
    private Double totalaPagar;

	public Totales(Integer id, String impaga, String fechapago, String formaPago, Double subTotal, Double subtoTaliva,
			Double subTotalcesc, Double subTotaldescuentos, Double totalaPagar) {
		super();
		this.id = id;
		this.impaga = impaga;
		this.fechapago = fechapago;
		this.formaPago = formaPago;
		this.subTotal = subTotal;
		this.subtoTaliva = subtoTaliva;
		this.subTotalcesc = subTotalcesc;
		this.subTotaldescuentos = subTotaldescuentos;
		this.totalaPagar = totalaPagar;
	}

	public Totales() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImpaga() {
		return impaga;
	}

	public void setImpaga(String impaga) {
		this.impaga = impaga;
	}

	public String getFechapago() {
		return fechapago;
	}

	public void setFechapago(String fechapago) {
		this.fechapago = fechapago;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getSubtoTaliva() {
		return subtoTaliva;
	}

	public void setSubtoTaliva(Double subtoTaliva) {
		this.subtoTaliva = subtoTaliva;
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
