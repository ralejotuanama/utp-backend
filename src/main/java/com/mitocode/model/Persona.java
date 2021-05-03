package com.mitocode.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "persona")
public class Persona {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;

	@Schema(description = "nombres de la persona")
	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@Size(min = 3, message = "Apellidos debe tener minimo 3 caracteres")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	@Size(min = 8, max = 8, message = "DNI debe tener 8 caracteres")
	@Column(name = "dni", nullable = false, length = 8) // unique = true
	private String dni;

	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	@Column(name = "direccion", nullable = true, length = 150)
	private String direccion;

	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = true, length = 9)
	private String telefono;
	
	@Size(min = 9, max = 9, message = "celular debe tener 9 caracteres")
	@Column(name = "celular", nullable = true, length = 9)
	private String celular;
	
	
	

	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "nombrescontacto", nullable = false, length = 70)
	private String nombrescontacto;

	

	@Size(min = 3, message = "Apellidos debe tener minimo 3 caracteres")
	@Column(name = "apellidoscontacto", nullable = false, length = 70)
	private String apellidoscontacto;
	
	
	
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefonocontacto", nullable = true, length = 9)
	private String telefonocontacto;
	
	@Size(min = 9, max = 9, message = "celular debe tener 9 caracteres")
	@Column(name = "celularcontacto", nullable = true, length = 9)
	private String celularcontacto;
	
	// Es a nivel logico
		@OneToMany(mappedBy = "persona", cascade = { CascadeType.ALL }, orphanRemoval = true)
		private List<Experiencia> listaexperiencia;

	
		// Es a nivel logico
		@OneToMany(mappedBy = "persona", cascade = { CascadeType.ALL }, orphanRemoval = true)
		private List<Certificacion> listacertificacion;
	
	
		// Es a nivel logico
				@OneToMany(mappedBy = "persona", cascade = { CascadeType.ALL }, orphanRemoval = true)
				private List<Conocimiento> listaconocimiento;
				
				
				
	
	public List<Conocimiento> getListaconocimiento() {
					return listaconocimiento;
				}

				public void setListaconocimiento(List<Conocimiento> listaconocimiento) {
					this.listaconocimiento = listaconocimiento;
				}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getNombrescontacto() {
		return nombrescontacto;
	}

	public void setNombrescontacto(String nombrescontacto) {
		this.nombrescontacto = nombrescontacto;
	}

	public String getApellidoscontacto() {
		return apellidoscontacto;
	}

	public void setApellidoscontacto(String apellidoscontacto) {
		this.apellidoscontacto = apellidoscontacto;
	}

	public String getTelefonocontacto() {
		return telefonocontacto;
	}

	public void setTelefonocontacto(String telefonocontacto) {
		this.telefonocontacto = telefonocontacto;
	}

	public String getCelularcontacto() {
		return celularcontacto;
	}

	public void setCelularcontacto(String celularcontacto) {
		this.celularcontacto = celularcontacto;
	}
	
	
	public List<Experiencia> getListaexperiencia() {
		return listaexperiencia;
	}

	public void setListaexperiencia(List<Experiencia> listaexperiencia) {
		this.listaexperiencia = listaexperiencia;
	}
	

	public List<Certificacion> getListacertificacion() {
			return listacertificacion;
	}

	public void setListacertificacion(List<Certificacion> listacertificacion) {
			this.listacertificacion = listacertificacion;
		}


}
