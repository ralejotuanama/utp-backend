package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mitocode.model.Persona;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPersonaRepo;

import com.mitocode.service.IPersonaService;


@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService{

	@Autowired
	private IPersonaRepo repo;
	
	
	@Override
	protected IGenericRepo<Persona, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}


	@Override
	public Persona RegistrarCompuesto(Persona per) throws Exception {
		// TODO Auto-generated method stub
		
		per.getListaexperiencia().forEach(p ->p.setPersona(per));
		per.getListacertificacion().forEach(p ->p.setPersona(per));
		per.getListaconocimiento().forEach(p ->p.setPersona(per));
		return repo.save(per);
	}

}
