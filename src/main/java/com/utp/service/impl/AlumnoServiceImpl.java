package com.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.model.Alumno;

import com.utp.repo.IAlumnoRepo;
import com.utp.repo.IGenericRepo;

import com.utp.service.IAlumnoService;



@Service
public class AlumnoServiceImpl extends CRUDImpl<Alumno, Integer> implements IAlumnoService{

	@Autowired
	private IAlumnoRepo repo;
	
	
	@Override
	protected IGenericRepo<Alumno, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}


	@Override
	public Alumno RegistrarCompuesto(Alumno alu) throws Exception {
		// TODO Auto-generated method stub
		
		alu.getListanotas().forEach(p ->p.setAlumno(alu));
		
		return repo.save(alu);
	}

}
