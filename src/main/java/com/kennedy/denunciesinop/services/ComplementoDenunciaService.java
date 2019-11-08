package com.kennedy.denunciesinop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennedy.denunciesinop.domain.ComplementoDenuncia;
import com.kennedy.denunciesinop.repositories.ComplementosDenunciaRepository;
import com.kennedy.denunciesinop.services.exceptions.ObjectNotFoundException;

@Service
public class ComplementoDenunciaService {

	@Autowired
	private ComplementosDenunciaRepository repo;
	
	public ComplementoDenuncia buscar(Integer id) {
		
		Optional<ComplementoDenuncia> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id
															+ ", tipo: " + ComplementoDenuncia.class.getName()));
	}
}