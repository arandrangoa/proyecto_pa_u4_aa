package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.funcional.ICiudadanoFunction;
import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.ICiudadanoRepo;


@Service
public class CiudadanoServiceImpl implements ICuidadanoService{
	
	@Autowired
	private ICiudadanoRepo ciudadanoRepo;
	
	@Autowired
	private IEstudianteService estudianteService;

	@Override
	public List<Ciudadano> consultarTodos() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepo.consultarTodos();
	}
	


	@Override
	public void convertir(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		ICiudadanoFunction<Estudiante, Ciudadano> function= ciu ->{
			Estudiante est=new Estudiante();
			
			est.setNombreCompleto(ciu.getNombre()+" "+ciu.getApellido());
			int edadfinal=(int) ChronoUnit.YEARS.between(LocalDateTime.now(), ((Ciudadano) ciu).getFechaNacimiento());
			est.setEdad(edadfinal);
			return est;
		};
		Ciudadano ciu=new Ciudadano();
		ciu.setNombre(ciudadano.getNombre());
		ciu.setApellido(ciudadano.getApellido());
		ciu.setFechaNacimiento(ciudadano.getFechaNacimiento());
		
		Estudiante estuConver=function.aplicar(ciu);
		System.out.println("Ciudadano convertido: " + estuConver);
		this.estudianteService.agregar(estuConver);
	}
		
}



