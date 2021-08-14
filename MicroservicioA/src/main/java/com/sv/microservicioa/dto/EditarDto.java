package com.sv.microservicioa.dto;

import java.io.Serializable;
public class EditarDto implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	//Variables:
    private Integer numeroFacturas;
    private Integer idEmpresa;
    private String fecha;
	public EditarDto(int numeroFacturas, int idEmpresa, String fecha) {
		super();
		this.numeroFacturas = numeroFacturas;
		this.idEmpresa = idEmpresa;
		this.fecha = fecha;
	}
	public EditarDto() {
		super();
	}
	public int getNumeroFacturas() {
		return numeroFacturas;
	}
	public void setNumeroFacturas(int numeroFacturas) {
		this.numeroFacturas = numeroFacturas;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}  
    
    //constructores:
    
	
	
}
