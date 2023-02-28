package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepoImpl implements ICiudadanoRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Ciudadano> consultarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c", Ciudadano.class);
		List<Ciudadano> lista=myQuery.getResultList();
		return lista;
	}

}
