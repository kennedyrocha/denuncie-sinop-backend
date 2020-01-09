package com.kennedy.denunciesinop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kennedy.denunciesinop.domain.Emergencia;
import com.kennedy.denunciesinop.domain.Usuario;

@Repository
public interface EmergenciaRepository extends JpaRepository<Emergencia, Integer> {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Emergencia obj WHERE obj.usuario.id = :usuarioId ORDER BY obj.id")
	List<Emergencia> findEmergencias(@Param("usuarioId") Integer usuario_id);
	
	@Transactional(readOnly=true)
	List<Emergencia> findByUsuario(Usuario usuario);
}