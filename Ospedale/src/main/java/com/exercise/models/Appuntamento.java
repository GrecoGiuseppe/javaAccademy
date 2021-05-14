package com.exercise.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "appuntamento")
@NoArgsConstructor
@AllArgsConstructor
public class Appuntamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAppuntamento;
	
	@Column(name = "dataAppuntamento")
	private Date dataAppuntamento;
	
	@Column(name = "visitaEffettuata")
	private Boolean visitaEffettuata;
	
	@ManyToOne
	private Paziente paziente;
	
	@ManyToOne
	private Medico medico;

	// Prima di uscire a mangiare sushi lavare capelli
	
	
}
