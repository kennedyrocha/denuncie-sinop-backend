package com.kennedy.denunciesinop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kennedy.denunciesinop.domain.Denuncia;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Denuncia obj WHERE obj.usuario.id = :usuarioId ORDER BY obj.id")
	List<Denuncia> findDenuncias(@Param("usuarioId") Integer usuario_id);
}
