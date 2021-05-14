package com.exercise.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "paziente")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Paziente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaziente;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "codiceFiscale")
	private String codiceFiscale;
	
	@Column(name = "dataNascita")
	private Date dataNascita;
	
	@Column(name = "eta")
	private Integer eta;
	
	@JsonIgnore
	@OneToMany(mappedBy = "paziente")
	private Set<Appuntamento> appuntamenti;
	
	
}

