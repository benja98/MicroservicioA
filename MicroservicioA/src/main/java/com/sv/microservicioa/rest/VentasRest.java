package com.sv.microservicioa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

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
	
	
	@PutMapping(value = "/editar")
	private ResponseEntity<?> editar(@RequestBody VentasDto vdto) {
		 
		ResponseEntity<?> response = null;
		try {
			
			  vS.EditarVentas(vdto);
			response = responseExceptions.createOkResponse(null, "0", "ok");
			
		} catch (DatosNoEncontradosException e) {
			response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response = responseExceptions.createFailResponse(null, "409", "error al ingresar datos");
		}
		return response;
	} 
	
	
	@DeleteMapping(value = "/eliminar/{id}")																				
	private ResponseEntity<Void> eliminarPersona (@PathVariable("id") Integer id){
		ResponseEntity<Void> response = null;	
	try {
		vS.delete(id);
		responseExceptions.createOkResponse(null, "0", "ok");
	}catch (DatosNoEncontradosException e) {
		response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
	}catch (Exception e) {
		e.printStackTrace();
		response = responseExceptions.createFailResponse(null, "409","error al eliminar datos");
	}
	return ResponseEntity.ok().build();
	}
	
	
	 
	
	
	  @GetMapping(value = "/totalizarSubTotales")
	    private ResponseEntity<String> totalizarSubT() {
	        
	        ResponseEntity<Optional<Ventas>> response = null;
	        try {
 	           // vS.totalizarSubT();
	            response = responseExceptions.createOkResponse(null, "0", "ok");
	           
	        } catch (DatosNoEncontradosException e) {
	            response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	            response = responseExceptions.createFailResponse(null, "409", "No se totalizo los subTotales");
	        }
	        System.out.println("Subtotales: ");
	        return ResponseEntity.ok(vS.imprimirCalculos());   
	    }
	
	  
	  
	  @GetMapping(value = "/totalizarEfectivoPercibido")
	    private ResponseEntity<String> efectivoPercibido() {
	        
	        ResponseEntity<Optional<Ventas>> response = null;
	        try {
	           // vS.totalizarSubT();
	            response = responseExceptions.createOkResponse(null, "0", "ok");
	           
	        } catch (DatosNoEncontradosException e) {
	            response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	            response = responseExceptions.createFailResponse(null, "409", "No se totalizo los subTotales");
	        }
	        return ResponseEntity.ok(vS.imprimirEfectivoPercibido());   
	    }

}
