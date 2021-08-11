package com.sv.microservicioa.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "facturas")
public class Facturas  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="id")
    private int id;
	
    @Column(name="numerofactura")
    private int numeroFactura;
    
    @Column(name="tipofactura")
    private String tipoFactura;
    
    @Column(name="impresa")
    private String impresa;
    
    @JoinColumn(name="totalesid" , referencedColumnName= "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Totales totalesId;

	public Facturas(int id, int numeroFactura, String tipoFactura, String impresa, Totales totalesId) {
		super();
		this.id = id;
		this.numeroFactura = numeroFactura;
		this.tipoFactura = tipoFactura;
		this.impresa = impresa;
		this.totalesId = totalesId;
	}

	public Facturas() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public String getImpresa() {
		return impresa;
	}

	public void setImpresa(String impresa) {
		this.impresa = impresa;
	}

	public Totales getTotalesId() {
		return totalesId;
	}

	public void setTotalesId(Totales totalesId) {
		this.totalesId = totalesId;
	}

    
}
