package com.kennedy.denunciesinop.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kennedy.denunciesinop.domain.Emergencia;
import com.kennedy.denunciesinop.services.EmergenciaService;

@RestController
@RequestMapping(value="/emergencias")
public class EmergenciaResource {
	
	@Autowired
	private EmergenciaService service;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id){
		

		Emergencia obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
