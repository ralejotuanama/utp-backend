package com.mitocode.model;

import java.time.LocalDateTime;

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
@Table(name = "experiencia")
public class Experiencia {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idExperiencia;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false, foreignKey = @ForeignKey(name = "FK_persona_experiencia"))
	private Persona persona;
	
	
	@Column(name = "fechainicio", nullable = false)
	private LocalDateTime fechainicio;
	
	

	@Column(name = "fechatermino", nullable = false)
	private LocalDateTime fechatermino;
	
	
	@Column(name = "descripcion", nullable = false, length = 70)
	private String descripcion;


	public Integer getIdExperiencia() {
		return idExperiencia;
	}


	public void setIdExperiencia(Integer idExperiencia) {
		this.idExperiencia = idExperiencia;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public LocalDateTime getFechainicio() {
		return fechainicio;
	}


	public void setFechainicio(LocalDateTime fechainicio) {
		this.fechainicio = fechainicio;
	}


	public LocalDateTime getFechatermino() {
		return fechatermino;
	}


	public void setFechatermino(LocalDateTime fechatermino) {
		this.fechatermino = fechatermino;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

}
