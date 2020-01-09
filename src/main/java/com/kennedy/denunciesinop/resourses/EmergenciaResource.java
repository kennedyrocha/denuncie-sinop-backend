package com.kennedy.denunciesinop.resourses;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kennedy.denunciesinop.domain.Emergencia;
import com.kennedy.denunciesinop.dto.EmergenciaDTO;
import com.kennedy.denunciesinop.security.UserSS;
import com.kennedy.denunciesinop.services.EmergenciaService;
import com.kennedy.denunciesinop.services.UserService;
import com.kennedy.denunciesinop.services.exceptions.AuthorizationException;

@RestController
@RequestMapping(value="/emergencias")
public class EmergenciaResource {
	
	@Autowired
	private EmergenciaService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<EmergenciaDTO> find(@PathVariable Integer id){
		
		UserSS user = UserService.authenticated();

		if (user ==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Emergencia obj = service.find(id);
		
		return ResponseEntity.ok().body(new EmergenciaDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EmergenciaDTO>> findAll(){
		
		UserSS user = UserService.authenticated();

		if (user ==null) {
			throw new AuthorizationException("Acesso negado");
		}

		List<Emergencia> lista = service.findAll();
		
		List<EmergenciaDTO> listDto = lista.stream().map(obj -> new EmergenciaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/usuario", method=RequestMethod.GET)
	public ResponseEntity<List<EmergenciaDTO>> findAllByUsuario(@RequestParam Integer usuario_id){
		
		UserSS user = UserService.authenticated();

		if (user ==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		List<Emergencia> lista = service.findAllByUsuario(usuario_id);
		
		List<EmergenciaDTO> listDto = lista.stream().map(obj -> new EmergenciaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Emergencia obj){
		
		UserSS user = UserService.authenticated();

		if (user ==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Emergencia obj, @PathVariable Integer id){
		
		UserSS user = UserService.authenticated();

		if (user ==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		obj.setId(id);
		
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		UserSS user = UserService.authenticated();

		if (user ==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
