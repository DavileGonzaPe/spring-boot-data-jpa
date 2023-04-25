package com.davile.springboot.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.davile.springboot.app.models.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		return entityManager.createQuery("from Cliente").getResultList();
	}

	@Override
	public Cliente findOne(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	@Override
	public void save(Cliente cliente) {
		if (cliente.getId() != null && cliente.getId() > 0) {
			entityManager.merge(cliente);
		} else {
			entityManager.persist(cliente);
		}

	}

	@Override
	public void delete(Long id) {
		Cliente cliente = findOne(id);
		entityManager.remove(cliente);
	}

}
