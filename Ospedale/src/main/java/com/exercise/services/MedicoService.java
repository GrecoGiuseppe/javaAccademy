package com.exercise.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.models.Medico;
import com.exercise.repositories.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	
	public Medico findById(Integer id) {
		return medicoRepository.findById(id).get();
	}

	public void addMedico(Medico medico) {

		medicoRepository.save(medico);
	}

	public Date getLaurea(Integer idMedico) {
		return medicoRepository.getLaurea(idMedico);
	}

	public Integer numeroVisite(Integer idMedico) {
		
		return medicoRepository.numeroVisite(idMedico);
	}
}
