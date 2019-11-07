package com.kennedy.denunciesinop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennedy.denunciesinop.domain.Emergencia;
import com.kennedy.denunciesinop.repositories.EmergenciaRepository;

@Service
public class EmergenciaService {

	@Autowired
	EmergenciaRepository repo;
	
	public Emergencia find(Integer id) {
		
		Optional<Emergencia> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Emergencia insert(Emergencia obj) {
		
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Emergencia update(Emergencia obj) {
		
		this.find(obj.getId());
		return repo.save(obj);
	}
}
