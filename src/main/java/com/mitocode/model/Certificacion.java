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
@Table(name = "certificacion")
public class Certificacion {

	
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCertificacion;
	



	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false, foreignKey = @ForeignKey(name = "FK_persona_certificacion"))
	private Persona persona;
	
	@Column(name = "nombrecertificacion", nullable = false, length = 70)
	private String nombrecertificacion;
	
	
	@Column(name = "descripcioncertificacion", nullable = false, length = 70)
	private String descripcioncertificacion;
	
	
	
	


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public String getNombrecertificacion() {
		return nombrecertificacion;
	}


	public void setNombrecertificacion(String nombrecertificacion) {
		this.nombrecertificacion = nombrecertificacion;
	}


	public String getDescripcioncertificacion() {
		return descripcioncertificacion;
	}


	public void setDescripcioncertificacion(String descripcioncertificacion) {
		this.descripcioncertificacion = descripcioncertificacion;
	}
	
	
	public Integer getIdCertificacion() {
		return idCertificacion;
	}


	public void setIdCertificacion(Integer idCertificacion) {
		this.idCertificacion = idCertificacion;
	}
}
