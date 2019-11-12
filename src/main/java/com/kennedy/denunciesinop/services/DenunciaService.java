package com.kennedy.denunciesinop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kennedy.denunciesinop.domain.Denuncia;
import com.kennedy.denunciesinop.repositories.DenunciaRepository;
import com.kennedy.denunciesinop.services.exceptions.ObjectNotFoundException;

@Service
public class DenunciaService {

	@Autowired
	DenunciaRepository repo;
	
	public Denuncia find(Integer id) {
		
		Optional<Denuncia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id
								+ ", tipo: " + Denuncia.class.getName()));
	}
	
	public List<Denuncia> findAll() {
		
		List<Denuncia> obj = repo.findAll();
		return obj;
	}
	
	public List<Denuncia> findAllByUsuario(Integer usuario_id) {
		
		List<Denuncia> obj = repo.findDenuncias(usuario_id);
		return obj;
	}
	
	public Denuncia insert(Denuncia obj) {
		
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Denuncia update(Denuncia obj) {
		
		this.find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		
		this.find(id);
		
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possível escluir pois há entidades relacionadas");
		}
	}
}
