package com.exercise.controllers;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.models.Appuntamento;
import com.exercise.models.Paziente;
import com.exercise.services.AppuntamentoService;

@RestController
@RequestMapping("/appuntamento")
public class AppuntamentoController {

	@Autowired
	private AppuntamentoService appuntamentoService;
	
	@GetMapping("/getAppuntamenti/{idPaziente}/{idMedico}")
	public List<Appuntamento> getAppuntamenti(@PathVariable Integer idPaziente, @PathVariable Integer idMedico){
		
		return appuntamentoService.getAppuntamenti(idPaziente,idMedico);
	}
	
	@GetMapping("/appuntamentiDiOggi")
	public List<Appuntamento> appuntamentiDiOggi() throws ParseException{
		return appuntamentoService.appuntamentiDiOggi();
	}
	
	@PostMapping("/addAppuntamento/{codiceFiscale}/{idMedico}/{data}")
	public void addAppuntamento(@PathVariable String codiceFiscale,@PathVariable Integer idMedico,@PathVariable String data) throws ParseException {
		
		appuntamentoService.addAppuntamento(codiceFiscale,idMedico,data);
	}
	
	@GetMapping("/almenoDueStessoMedico/{idMedico}")
	public List<Paziente> almenoDueStessoMedico(@PathVariable Integer idMedico){
		return appuntamentoService.almenoDueStessoMedico(idMedico);
	}
	
	@GetMapping("/almenoDueCardiologica")
	public List<Paziente> almenoDueCardiologica(){
		return appuntamentoService.almenoDueCardiologica();
	}
	
	
}
