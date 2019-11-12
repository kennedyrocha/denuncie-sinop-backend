package com.kennedy.denunciesinop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kennedy.denunciesinop.domain.Usuario;
import com.kennedy.denunciesinop.repositories.UsuarioRepository;
import com.kennedy.denunciesinop.services.exceptions.DataIntegrityException;
import com.kennedy.denunciesinop.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Integer id) {
		
		Optional<Usuario> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id
										+ ", tipo: " + Usuario.class.getName()));
	}
	
	public Usuario update(Usuario obj) {
		
		Usuario newObj = this.find(obj.getId());
		this.updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	public void delete (Integer id) {

		this.find(id);

		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não possível excluir pois há entidades relacionadas");
		}
	}
	
	public Usuario insert(Usuario obj) {
		
		obj.setId(null);
		return repo.save(obj);
	}

	
	private void updateData(Usuario objNew, Usuario obj) {
		
		objNew.setEmail(obj.getEmail());
		objNew.setNome(obj.getNome());
	}
}
