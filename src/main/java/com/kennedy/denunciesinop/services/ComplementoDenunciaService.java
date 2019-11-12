package com.kennedy.denunciesinop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennedy.denunciesinop.domain.ComplementoDenuncia;
import com.kennedy.denunciesinop.domain.Denuncia;
import com.kennedy.denunciesinop.repositories.ComplementosDenunciaRepository;
import com.kennedy.denunciesinop.services.exceptions.ObjectNotFoundException;

@Service
public class ComplementoDenunciaService {

	@Autowired
	private ComplementosDenunciaRepository repo;
	
	@Autowired
	private DenunciaService denunciaService;
	
	public ComplementoDenuncia find(Integer id) {
		
		Optional<ComplementoDenuncia> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id
															+ ", tipo: " + ComplementoDenuncia.class.getName()));
	}
	
	public ComplementoDenuncia insert(ComplementoDenuncia obj, Integer denuncia_id) {
		
		Denuncia denuncia = denunciaService.find(denuncia_id);
		obj.setId(null);
		obj.setDenuncia(denuncia);
		return repo.save(obj);
	}
}