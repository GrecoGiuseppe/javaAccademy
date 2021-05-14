package com.exercise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.models.Paziente;
import com.exercise.repositories.PazienteRepository;

@Service
public class PazienteService {

	@Autowired
	PazienteRepository pazienteRepository;
	
	public Paziente getPazienteByCodiceFiscale(String codiceFiscale) {
		return pazienteRepository.findBycodiceFiscale(codiceFiscale);
	}

	public void addPaziente(Paziente paziente) {
		pazienteRepository.save(paziente);
		
	}
	
	public List<Paziente> maiVisitati() {
		
		return pazienteRepository.maiVisitati();
	}
}
