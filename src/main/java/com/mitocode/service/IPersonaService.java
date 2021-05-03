package com.mitocode.service;


import com.mitocode.model.Persona;

public interface IPersonaService extends ICRUD<Persona, Integer>{

	Persona RegistrarCompuesto(Persona per) throws Exception;
}
