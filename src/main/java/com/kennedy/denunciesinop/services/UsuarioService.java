package com.kennedy.denunciesinop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennedy.denunciesinop.domain.Usuario;
import com.kennedy.denunciesinop.repositories.UsuarioRepository;
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
}
