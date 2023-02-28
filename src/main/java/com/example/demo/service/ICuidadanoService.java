package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;


public interface ICuidadanoService {

	public List<Ciudadano> consultarTodos();
	
	public void convertir(Ciudadano ciudadano);
	
}
