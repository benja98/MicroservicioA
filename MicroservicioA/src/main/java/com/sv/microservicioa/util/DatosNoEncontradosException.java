package com.sv.microservicioa.util;

public class DatosNoEncontradosException extends RuntimeException{ 
	   
    private static final long serialVersionUID = 1L;
    private final String cod;

 

    public DatosNoEncontradosException(String mensaje) {
        super(mensaje); 
        this.cod = "";
    }
    
    public DatosNoEncontradosException(String cod, String mensaje) {
        super(mensaje); 
        this.cod = cod; 
    }

 

    public String getCod() {
        return cod;
    }
}


 
