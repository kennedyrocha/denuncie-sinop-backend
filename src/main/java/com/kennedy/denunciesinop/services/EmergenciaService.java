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
	
	public Emergencia buscar(Integer id) {
		
		Optional<Emergencia> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
