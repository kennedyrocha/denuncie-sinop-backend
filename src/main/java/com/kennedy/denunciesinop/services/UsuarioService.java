package com.kennedy.denunciesinop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kennedy.denunciesinop.domain.Usuario;
import com.kennedy.denunciesinop.domain.enums.Perfil;
import com.kennedy.denunciesinop.dto.UsuarioDTO;
import com.kennedy.denunciesinop.repositories.UsuarioRepository;
import com.kennedy.denunciesinop.security.UserSS;
import com.kennedy.denunciesinop.services.exceptions.AuthorizationException;
import com.kennedy.denunciesinop.services.exceptions.DataIntegrityException;
import com.kennedy.denunciesinop.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Usuario find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso Negado");
		}
		
		Optional<Usuario> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id
										+ ", tipo: " + Usuario.class.getName()));
	}
	
	public Usuario update(Usuario obj) {
		
		Usuario newObj = this.find(obj.getId());
		this.updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public Usuario fromDTO(UsuarioDTO objDTO) {
		
		return new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), objDTO.getCpfOuCnpj(), pe.encode(objDTO.getSenha()));
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

			throw new DataIntegrityException("Não possível excluir pois há denúncias e/ou emergências para esse cliente");
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
