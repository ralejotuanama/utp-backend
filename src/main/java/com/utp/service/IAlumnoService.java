package com.utp.service;


import com.utp.model.Alumno;


public interface IAlumnoService extends ICRUD<Alumno, Integer>{

	Alumno RegistrarCompuesto(Alumno alu) throws Exception;
}
