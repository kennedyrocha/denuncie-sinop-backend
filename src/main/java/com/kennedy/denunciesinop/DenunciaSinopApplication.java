package com.kennedy.denunciesinop;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kennedy.denunciesinop.domain.ComplementoDenuncia;
import com.kennedy.denunciesinop.domain.Denuncia;
import com.kennedy.denunciesinop.domain.Emergencia;
import com.kennedy.denunciesinop.domain.Usuario;
import com.kennedy.denunciesinop.repositories.ComplementosDenunciaRepository;
import com.kennedy.denunciesinop.repositories.DenunciaRepository;
import com.kennedy.denunciesinop.repositories.EmergenciaRepository;
import com.kennedy.denunciesinop.repositories.UsuarioRepository;

@SpringBootApplication
public class DenunciaSinopApplication implements CommandLineRunner {

	@Autowired
	EmergenciaRepository emergenciaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	DenunciaRepository denunciaRepository;
	
	@Autowired
	ComplementosDenunciaRepository complementosDenunciaRepository;
	
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

		Denuncia den1 = new Denuncia(null, "Teste de denúncia 1", 56, 98, true, usu1);
		Denuncia den2 = new Denuncia(null, "Teste de denúncia 2", 22, 16, false, usu1);
		Denuncia den3 = new Denuncia(null, "Teste de denúncia 3", 43, 36, true, usu2);
		Denuncia den4 = new Denuncia(null, "Teste de denúncia 4", 75, 49, false, usu2);
		
		ComplementoDenuncia cde1 = new ComplementoDenuncia(null, "Complementos da denúncia 1", 15, 21, den1);
		ComplementoDenuncia cde2 = new ComplementoDenuncia(null, "Complementos da denúncia 2", 65, 19, den2);
		ComplementoDenuncia cde3 = new ComplementoDenuncia(null, "Complementos da denúncia 2-2", 87, 31, den2);
		
		usu1.getEmergencias().addAll(Arrays.asList(em1,em3));
		usu2.getEmergencias().addAll(Arrays.asList(em2,em4));
		
		usu1.getDenuncias().addAll(Arrays.asList(den1,den2));
		usu2.getDenuncias().addAll(Arrays.asList(den3,den4));
		
		den1.getComplementos().addAll(Arrays.asList(cde1));
		den2.getComplementos().addAll(Arrays.asList(cde2,cde3));

		usuarioRepository.saveAll(Arrays.asList(usu1,usu2));
		emergenciaRepository.saveAll(Arrays.asList(em1,em2,em3,em4));
		denunciaRepository.saveAll(Arrays.asList(den1,den2,den3,den4));
		complementosDenunciaRepository.saveAll(Arrays.asList(cde1,cde2,cde3));
		
	}
}
