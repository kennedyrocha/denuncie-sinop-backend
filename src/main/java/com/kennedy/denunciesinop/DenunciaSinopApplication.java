package com.kennedy.denunciesinop;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kennedy.denunciesinop.domain.Emergencia;
import com.kennedy.denunciesinop.domain.Usuario;
import com.kennedy.denunciesinop.repositories.EmergenciaRepository;
import com.kennedy.denunciesinop.repositories.UsuarioRepository;

@SpringBootApplication
public class DenunciaSinopApplication implements CommandLineRunner {

	@Autowired
	EmergenciaRepository emergenciaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {		
		SpringApplication.run(DenunciaSinopApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		Usuario usu1 = new Usuario(null,"Maria Silva", "kennedy@gmail.com","05333533199");
		Usuario usu2 = new Usuario(null,"Maria Silva", "kennedy2@gmail.com","36378912377");
		
		Emergencia em1 = new Emergencia(null, 2, 15, 20, usu1);
		Emergencia em2 = new Emergencia(null, 1, 18, 98, usu2);
		Emergencia em3 = new Emergencia(null, 5, 30, 53, usu1);
		Emergencia em4 = new Emergencia(null, 4, 30, 39, usu2);
		
		usu1.getEmergencias().addAll(Arrays.asList(em1,em3));
		usu2.getEmergencias().addAll(Arrays.asList(em2,em4));

		usuarioRepository.saveAll(Arrays.asList(usu1,usu2));
		emergenciaRepository.saveAll(Arrays.asList(em1,em2,em3,em4));
	}
}
