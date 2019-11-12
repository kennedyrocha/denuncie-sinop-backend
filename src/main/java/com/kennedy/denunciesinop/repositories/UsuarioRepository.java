package com.kennedy.denunciesinop.repositories;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kennedy.denunciesinop.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
}