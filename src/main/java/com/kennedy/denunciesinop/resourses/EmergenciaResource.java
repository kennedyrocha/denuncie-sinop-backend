package com.kennedy.denunciesinop.resourses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kennedy.denunciesinop.domain.Emergencia;

@RestController
@RequestMapping(value="/emergencias")
public class EmergenciaResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Emergencia> listar(){
		;
		List<Emergencia> lista = new ArrayList<>();
		
		lista.add(new Emergencia(1, 2, 15, 20));
		lista.add(new Emergencia(2, 1, 18, 98));
		lista.add(new Emergencia(3, 5, 30, 3));
		
		return lista;
	}
}
