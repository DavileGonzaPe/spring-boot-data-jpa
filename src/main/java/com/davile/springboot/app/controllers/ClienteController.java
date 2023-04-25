package com.davile.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.davile.springboot.app.models.dao.IClienteDao;
import com.davile.springboot.app.models.entity.Cliente;

import jakarta.validation.Valid;

@Controller
public class ClienteController {
	
	@Autowired
	@Qualifier("clienteDaoJPA")
	private IClienteDao clienteDao;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de cliente");
		
		return "form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de cliente");
			return "form";
		}
		
		clienteDao.save(cliente);		
		return "redirect:listar";
	}
}
