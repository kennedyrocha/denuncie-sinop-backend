package com.kennedy.denunciesinop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennedy.denunciesinop.domain.Denuncia;
import com.kennedy.denunciesinop.repositories.DenunciaRepository;
import com.kennedy.denunciesinop.services.exceptions.ObjectNotFoundException;

@Service
public class DenunciaService {

	@Autowired
	DenunciaRepository repo;
	
	public Denuncia buscar(Integer id) {
		
		Optional<Denuncia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id
								+ ", tipo: " + Denuncia.class.getName()));
	}
}
