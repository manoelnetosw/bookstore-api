package com.mcmn.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcmn.bookstore.domain.Categoria;
import com.mcmn.bookstore.repositories.CategoriaRepository;
import com.mcmn.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
