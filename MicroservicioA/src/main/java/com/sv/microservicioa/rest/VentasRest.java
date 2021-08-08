package com.sv.microservicioa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.sv.microservicioa.dto.VentasDto;
import com.sv.microservicioa.modelo.Ventas;
import com.sv.microservicioa.service.VentasService;
import com.sv.microservicioa.util.DatosNoEncontradosException;
import com.sv.microservicioa.util.ResponseEntityExceptions;

@RestController
@RequestMapping("/ventas")
public class VentasRest {

	// Inyecciones:
	@Autowired
	private VentasService vS;
	@Autowired
	private ResponseEntityExceptions responseExceptions;

	
	
	
	@PostMapping(value = "/guardar")
	private ResponseEntity<?> guardar(@RequestBody VentasDto vdto) {
		 
		ResponseEntity<?> response = null;
		try {
			
			  vS.guardarVentas(vdto);
			response = responseExceptions.createOkResponse(null, "0", "ok");
			
		} catch (DatosNoEncontradosException e) {
			response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response = responseExceptions.createFailResponse(null, "409", "error al ingresar datos");
		}
		return response;
	}  
	
	
	
	
	@GetMapping(value = "/totalizarSubTotales")
	private ResponseEntity<List<Ventas>> totalizarSubT() {
		 
		ResponseEntity<List<Ventas>> response = null;
		try {
			
			List<Ventas> listaSubTotales = vS.totalizarSubT();
			response = responseExceptions.createOkResponse(listaSubTotales, "0", "ok");
			
		} catch (DatosNoEncontradosException e) {
			response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response = responseExceptions.createFailResponse(null, "409", "No se totalizo los subTotales");
		}
		return response;
	}  
	

}
