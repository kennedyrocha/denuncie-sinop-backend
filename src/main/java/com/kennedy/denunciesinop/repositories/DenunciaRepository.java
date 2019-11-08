package com.kennedy.denunciesinop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kennedy.denunciesinop.domain.Denuncia;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {

}
