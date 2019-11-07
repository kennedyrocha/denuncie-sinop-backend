package com.kennedy.denunciesinop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kennedy.denunciesinop.domain.Emergencia;
import com.kennedy.denunciesinop.repositories.EmergenciaRepository;

@SpringBootApplication
public class DenunciaSinopApplication implements CommandLineRunner {

	@Autowired
	EmergenciaRepository emergenciaRepository;
	
	public static void main(String[] args) {		
		SpringApplication.run(DenunciaSinopApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		
		Emergencia em1 = new Emergencia(null, 2, 15, 20);
		Emergencia em2 = new Emergencia(null, 1, 18, 98);
		Emergencia em3 = new Emergencia(null, 5, 30, 3);
		
		emergenciaRepository.save(em1);
		emergenciaRepository.save(em2);
		emergenciaRepository.save(em3);
	}

}
