package com.exercise.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercise.models.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

	@Query("SELECT m.dataLaurea FROM Medico m WHERE m.idMedico = ?1")
	Date getLaurea(Integer idMedico);

	@Query(value = "SELECT COUNT( a.id_appuntamento) FROM appuntamento a WHERE a.medico_id_medico = ?1 AND a.visita_effettuata = 1",
			nativeQuery = true)
	Integer numeroVisite(Integer idMedico);

}
