package com.sv.microservicioa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sv.microservicioa.dto.GuardarDto;
import com.sv.microservicioa.modelo.Ventas;

public interface GuardarRepository extends CrudRepository<Ventas,Integer>{

	List<Ventas> save(List<GuardarDto> vdto);



}
