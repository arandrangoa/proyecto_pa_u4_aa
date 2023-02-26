package com.example.demo.funcional;

public class PersonaSupplier2Impl implements IPersonaSupplier<Persona>{

	@Override
	public Persona getNombre() {
		Persona per= new Persona();
		per.setApellido("Andrango1");
		per.setNombre("Alex1");
		return per;
	}

}
