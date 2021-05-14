package com.exercise.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercise.models.Appuntamento;
import com.exercise.models.Medico;
import com.exercise.models.Paziente;

@Repository
public interface AppuntamentoRepositories extends JpaRepository<Appuntamento, Integer> {

	@Query(value = "SELECT a.* FROM appuntamento a WHERE a.paziente_id_paziente = ?1 AND a.medico_id_medico = ?2", nativeQuery = true)
	List<Appuntamento> getAppuntamenti(Integer idPaziente, Integer idMedico);

	@Query(value = "SELECT a.* FROM appuntamento a WHERE a.data_appuntamento = ?1", nativeQuery = true)
	List<Appuntamento> appuntamentiDiOggi(Date date);

	@Query("SELECT a.paziente FROM Appuntamento a WHERE a.medico = ?1 "
			+ "GROUP BY a.paziente , a.medico  HAVING count(*)>1")
	List<Paziente> almenoDueStessoMedico( Medico medico);

	@Query("SELECT a.paziente FROM Appuntamento a WHERE a.medico.specializzazione = 'cardiologo' "
			+ "GROUP BY a.paziente  HAVING count(*)>1")
	List<Paziente> almenoDueCardiologica();


}
