package com.exercise.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.models.Appuntamento;
import com.exercise.models.Medico;
import com.exercise.models.Paziente;
import com.exercise.repositories.AppuntamentoRepositories;

@Service
public class AppuntamentoService {

	@Autowired
	private AppuntamentoRepositories appuntamentoRepository;

	@Autowired
	private PazienteService pazienteService;
	
	@Autowired
	private MedicoService medicoService;
	
	public List<Appuntamento> getAppuntamenti(Integer idPaziente, Integer idMedico) {
		
		return appuntamentoRepository.getAppuntamenti(idPaziente,idMedico);
	}

	public List<Appuntamento> appuntamentiDiOggi() throws ParseException {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		Date oggi = sdf.parse(sdf.format(new Date()));
		
		
		return appuntamentoRepository.appuntamentiDiOggi(oggi);
	}

	public void addAppuntamento(String codiceFiscale, Integer idMedico,String data) throws ParseException {
		
		Paziente paziente = pazienteService.getPazienteByCodiceFiscale(codiceFiscale);
		
		Medico medico = medicoService.findById(idMedico);
		
		Date date = null;
		
		SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yy", Locale.ITALY);
		
		date = formatoData.parse(data);
		
		appuntamentoRepository.save(new Appuntamento(null, date, false, paziente, medico));
	}

	public List<Paziente> almenoDueStessoMedico(Integer idMedico) {

		
		Medico medico = medicoService.findById(idMedico);
		
		return appuntamentoRepository.almenoDueStessoMedico(medico);
	}

	public List<Paziente> almenoDueCardiologica() {
	
		
		return appuntamentoRepository.almenoDueCardiologica();
	}



}
