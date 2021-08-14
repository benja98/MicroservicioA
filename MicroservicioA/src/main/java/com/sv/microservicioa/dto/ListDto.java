package com.sv.microservicioa.dto;

import java.io.Serializable;
import java.util.List;

public class ListDto implements Serializable{

	private static final long serialVersionUID = 1L;

	public List<GuardarDto> datosList;

	public List<GuardarDto> getDatosList() {
		return datosList;
	}

	public void setDatosList(List<GuardarDto> datosList) {
		this.datosList = datosList;
	}
	
}
