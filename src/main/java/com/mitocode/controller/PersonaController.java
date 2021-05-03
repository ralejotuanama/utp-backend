package com.mitocode.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Paciente;
import com.mitocode.model.Persona;
import com.mitocode.service.IPacienteService;
import com.mitocode.service.IPersonaService;

@RestController
@RequestMapping("/personas")
//@CrossOrigin(origins = "localhost:4200")
public class PersonaController {

	@Autowired	
	private IPersonaService service;
	
	@GetMapping
	public ResponseEntity<List<Persona>> listar() throws Exception{
		List<Persona> lista = service.listar();
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Persona obj = service.listarPorId(id);
		if(obj == null ) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	//https://docs.spring.io/spring-hateoas/docs/current/reference/html/
	//Hateoas 0.9 = > Spring Boot 1.5 y 2.1
	//Hateoas 1.0 = > Spring Boot 2.2
	//Hateoas 1.1 = > Spring Boot 2.3
	@GetMapping("/hateoas/{id}")
	public EntityModel<Persona> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
		Persona obj = service.listarPorId(id);
		if(obj == null ) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		//localhost:8080/pacientes/{id}
		EntityModel<Persona> recurso = EntityModel.of(obj); //Antes: new EntityModel<Paciente>(obj);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		recurso.add(linkTo.withRel("persona-recurso"));
		
		return recurso;
	}
		
	/*@PostMapping
	public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente paciente) {
		Paciente obj = service.registrar(paciente);
		return new ResponseEntity<Paciente>(obj, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Persona persona) throws Exception{
		Persona obj = service.RegistrarCompuesto(persona);
		
		//localhost:8080/pacientes/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getIdPersona()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona persona) throws Exception{
		Persona obj = service.modificar(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Persona obj = service.listarPorId(id);
		if(obj.getIdPersona() == null ) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

}
