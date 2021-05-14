package com.exercise.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.models.Medico;
import com.exercise.services.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	
	@PostMapping("/addMedico")
	public void addMedico(@RequestBody Medico medico) {
		medicoService.addMedico(medico);
	}
	
	@GetMapping("/getLaurea")
	public Date getLaurea(@RequestParam Integer idMedico) {
		return medicoService.getLaurea(idMedico);
	}
	
	@GetMapping("/numeroVisite")
	public Integer numeroVisite(@RequestParam Integer idMedico) {
		return medicoService.numeroVisite(idMedico);
	}
}
