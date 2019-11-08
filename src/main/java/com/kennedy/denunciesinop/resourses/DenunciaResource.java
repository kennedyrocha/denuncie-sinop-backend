package com.kennedy.denunciesinop.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kennedy.denunciesinop.domain.Denuncia;
import com.kennedy.denunciesinop.services.DenunciaService;

@RestController
@RequestMapping(value="/denuncias")
public class DenunciaResource {

	@Autowired
	private DenunciaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Denuncia> buscar(@PathVariable Integer id){
		
		Denuncia obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
