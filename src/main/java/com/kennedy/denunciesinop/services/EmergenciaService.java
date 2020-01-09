package com.kennedy.denunciesinop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kennedy.denunciesinop.domain.Emergencia;
import com.kennedy.denunciesinop.repositories.EmergenciaRepository;
import com.kennedy.denunciesinop.security.UserSS;
import com.kennedy.denunciesinop.services.exceptions.AuthorizationException;
import com.kennedy.denunciesinop.services.exceptions.ObjectNotFoundException;

@Service
public class EmergenciaService {

	@Autowired
	EmergenciaRepository repo;
	
	public Emergencia find(Integer id) {
		
		Optional<Emergencia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id
									+ ", tipo: " + Emergencia.class.getName()));
	}
	
	public List<Emergencia> findAll() {

		UserSS user = UserService.authenticated();

		if (user ==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		List<Emergencia> obj = repo.findAll();
		return obj;
	}
	
	public List<Emergencia> findAllByUsuario(Integer usuario_id) {
		
		List<Emergencia> obj = repo.findEmergencias(usuario_id);
		return obj;
	}
	
	public Emergencia insert(Emergencia obj) {
		
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Emergencia update(Emergencia obj) {
		
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
