package com.kennedy.denunciesinop.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kennedy.denunciesinop.domain.ComplementoDenuncia;
import com.kennedy.denunciesinop.services.ComplementoDenunciaService;

@RestController
@RequestMapping(value="/complementosdenuncia")
public class ComplementoDenunciaResource {

	@Autowired
	private ComplementoDenunciaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ComplementoDenuncia> buscar(@PathVariable Integer id){
		
		ComplementoDenuncia obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
