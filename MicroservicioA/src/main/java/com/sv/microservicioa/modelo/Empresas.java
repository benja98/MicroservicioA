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
@Table(name="empresas") 
public class Empresas implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	
	//Variables:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="id")
	private Integer id;
	
	 @Column(name="empresa")
	private String empresa;

	
	// Constructores:
	public Empresas(Integer id, String empresa) {
		super();
		this.id = id;
		this.empresa = empresa;
	}

	public Empresas() {
		super();
	}
	
	
	// Get y set:

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	
	
	
	

}
