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

@Entity
@Data
@Table(name = "medico")
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "dataLaurea")
	private Date dataLaurea;
	
	@Column(name ="specializzazione")
	private String specializzazione;
	
	@JsonIgnore
	@OneToMany(mappedBy = "medico")
	private Set<Appuntamento> appuntamenti;
		
	//HO MODIFICATO QUESTA CLASSE

}
