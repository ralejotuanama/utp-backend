package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "conocimiento")
public class Conocimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConocimiento;
	



	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false, foreignKey = @ForeignKey(name = "FK_persona_conocimiento"))
	private Persona persona;
	
	@Column(name = "nombrehabilidad", nullable = false, length = 70)
	private String nombrehabilidad;
	
	
	@Column(name = "descripcionhabilidad", nullable = false, length = 70)
	private String descripcionhabilidad;
	
	public Integer getIdConocimiento() {
		return idConocimiento;
	}


	public void setIdConocimiento(Integer idConocimiento) {
		this.idConocimiento = idConocimiento;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public String getNombrehabilidad() {
		return nombrehabilidad;
	}


	public void setNombrehabilidad(String nombrehabilidad) {
		this.nombrehabilidad = nombrehabilidad;
	}


	public String getDescripcionhabilidad() {
		return descripcionhabilidad;
	}


	public void setDescripcionhabilidad(String descripcionhabilidad) {
		this.descripcionhabilidad = descripcionhabilidad;
	}

	
}
