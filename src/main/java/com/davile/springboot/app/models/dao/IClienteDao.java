package com.davile.springboot.app.models.dao;

import java.util.List;

import com.davile.springboot.app.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();
}