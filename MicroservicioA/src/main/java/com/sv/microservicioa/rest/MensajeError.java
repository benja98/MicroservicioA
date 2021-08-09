package com.sv.microservicioa.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MensajeError {
	private String mensaje;
	private int codigo;
	private String info;
	
	public MensajeError() {
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
