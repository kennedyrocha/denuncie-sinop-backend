package com.kennedy.denunciesinop.resourses;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kennedy.denunciesinop.domain.ComplementoDenuncia;
import com.kennedy.denunciesinop.domain.Denuncia;
import com.kennedy.denunciesinop.services.ComplementoDenunciaService;
import com.kennedy.denunciesinop.services.DenunciaService;

@RestController
@RequestMapping(value="/denuncias")
public class DenunciaResource {

	@Autowired
	private DenunciaService service;
	
	@Autowired
	private ComplementoDenunciaService serviceComplemento;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Denuncia> buscar(@PathVariable Integer id){
		
		Denuncia obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Denuncia>> findAll(){
		
		List<Denuncia> lista = service.findAll();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value="/usuario", method=RequestMethod.GET)
	public ResponseEntity<List<Denuncia>> findAllByUsuario(@RequestParam Integer usuario_id){
		
		List<Denuncia> lista = service.findAllByUsuario(usuario_id);
		
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Denuncia obj){
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/complemento",method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ComplementoDenuncia obj, @RequestParam Integer denuncia_id){
		
		obj = serviceComplemento.insert(obj, denuncia_id);
		
		return ResponseEntity.created(null).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Denuncia obj, @PathVariable Integer id){
		
		obj.setId(id);
		
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}