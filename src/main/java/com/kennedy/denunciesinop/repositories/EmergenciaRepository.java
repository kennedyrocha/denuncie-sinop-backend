package com.kennedy.denunciesinop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kennedy.denunciesinop.domain.Emergencia;

@Repository
public interface EmergenciaRepository extends JpaRepository<Emergencia, Integer> {

}
