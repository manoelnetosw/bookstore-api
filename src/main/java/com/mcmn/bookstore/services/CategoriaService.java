package com.mcmn.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mcmn.bookstore.domain.Categoria;
import com.mcmn.bookstore.dtos.CategoriaDTO;
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

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria newObj = findById(id);
		newObj.setNome(objDto.getNome());
		newObj.setDescricao(objDto.getDescricao());
		return repository.save(newObj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.mcmn.bookstore.services.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados!");
		}
			
	}
}
