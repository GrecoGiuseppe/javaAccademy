package com.exercise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.models.Paziente;
import com.exercise.services.PazienteService;

@RestController
@RequestMapping("/paziente")
public class PazienteController {

	@Autowired
	private PazienteService pazienteService;
	
	@PostMapping("/addPaziente")
	public void addPaziente(@RequestBody Paziente paziente) {
		pazienteService.addPaziente(paziente);
	}
	
	@GetMapping("/maiVisitati")
	public List<Paziente> maiVisitati(){
		return pazienteService.maiVisitati();
	}
	
}
