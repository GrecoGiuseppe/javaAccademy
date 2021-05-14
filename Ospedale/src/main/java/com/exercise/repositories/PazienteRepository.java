package com.exercise.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercise.models.Paziente;

@Repository
public interface PazienteRepository extends JpaRepository<Paziente, Integer> {

	Paziente findBycodiceFiscale(String codiceFiscale);
	
	@Query(value = "SELECT p.* FROM paziente p WHERE NOT EXISTS ( SELECT * FROM appuntamento a WHERE a.paziente_id_paziente = p.id_paziente"
			+ " AND a.visita_effettuata = 1) ", nativeQuery = true)
	List<Paziente> maiVisitati();

}
