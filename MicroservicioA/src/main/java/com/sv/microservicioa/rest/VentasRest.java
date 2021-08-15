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

import com.sv.microservicioa.dto.EditarDto;
import com.sv.microservicioa.dto.GuardarDto;
import com.sv.microservicioa.dto.ListDto;
import com.sv.microservicioa.modelo.Ventas;
import com.sv.microservicioa.service.VentasService;
import com.sv.microservicioa.util.DatosNoEncontradosException;
import com.sv.microservicioa.util.ResponseEntityExceptions;

@RestController
@RequestMapping("/ventas")
public class VentasRest {

	// Inyecciones:
	@Autowired
	private VentasService ventasservice;
	@Autowired
	private ResponseEntityExceptions responseExceptions;

	
////////////////----GUARDAR-----///////////////////////////////////////////////////////////////////////////////////////////////////////

		@PostMapping(value = "/guardar")
	public ResponseEntity<ListDto> SaveList (@RequestBody ListDto vdto) {
		ResponseEntity<ListDto> response = null;
		try {
			ventasservice.saveUserList(vdto);
			response = responseExceptions.createOkResponse(null, "0", "ok");
			
		} catch (DatosNoEncontradosException e) {
			response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response = responseExceptions.createFailResponse(null, "409", "error al ingresar datos");
		}
		return response;
	}  
	
////////////////----EDITAR-----///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PutMapping(value = "/editar")
	private ResponseEntity<?> editar(@RequestBody EditarDto vdto) {
		 
		ResponseEntity<?> response = null;
		try {
			ventasservice.EditarVentas(vdto);
			response = responseExceptions.createOkResponse(null, "0", "ok");
			
		} catch (DatosNoEncontradosException e) {
			response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response = responseExceptions.createFailResponse(null, "409", "error al editar datos");
		}
		return response;
	} 
	
////////////////----ELIMINAR-----///////////////////////////////////////////////////////////////////////////////////////////////////////

	@DeleteMapping(value = "/eliminar/{factura}")																				
	private ResponseEntity<Void> eliminarFactura (@PathVariable("factura") Integer facturas){
		ResponseEntity<Void> response = null;	
	try {
		ventasservice.delete(facturas);
		responseExceptions.createOkResponse(null, "0", "ok");
	}catch (DatosNoEncontradosException e) {
		response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
	}catch (Exception e) {
		e.printStackTrace();
		response = responseExceptions.createFailResponse(null, "409","error al eliminar datos");
	}
	return ResponseEntity.ok().build();
	}
	
	
////////////////----TOTALIZAR SUBTOTALES-----///////////////////////////////////////////////////////////////////////////////////////////////////////

	
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
	        return ResponseEntity.ok(ventasservice.imprimirCalculos());   
	    }
	
////////////////----TOTALIZAR EFECTIVO PERSIVIDO-----///////////////////////////////////////////////////////////////////////////////////////////////////////

	  
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
	        return ResponseEntity.ok(ventasservice.imprimirEfectivoPercibido());   
	    }

}
