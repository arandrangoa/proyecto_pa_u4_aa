package com.example.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;
import com.example.demo.service.ICuidadanoService;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class ProyectoPaU4AaApplication implements CommandLineRunner{
	
	
	@Autowired
	private ICuidadanoService cuidadanoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Ciudadano> c1= this.cuidadanoService.consultarTodos();
		long tiempoInicial = System.currentTimeMillis();
		for(Ciudadano ciu: c1) {
			
			this.cuidadanoService.convertir(ciu);
			
		}
		long tiempofinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempofinal - tiempoInicial) / 1000;
		System.out.println("Tiempo transcurrido al convertir Ciudadano en estudainte : " + tiempoTranscurrido);
		
		
		
		
	}

}
