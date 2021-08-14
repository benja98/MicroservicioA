package com.sv.microservicioa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sv.microservicioa.modelo.Empresas;
import com.sv.microservicioa.modelo.Ventas;

public interface EmpresasRepository extends JpaRepository<Empresas, Integer>{
	
	@Query(value = "select e from Empresas e where e.id = ?1")
	Empresas buscarid(Integer id);
}
