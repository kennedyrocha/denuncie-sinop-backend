package com.kennedy.denunciesinop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kennedy.denunciesinop.domain.ComplementoDenuncia;

@Repository
public interface ComplementosDenunciaRepository extends JpaRepository<ComplementoDenuncia, Integer>{

}