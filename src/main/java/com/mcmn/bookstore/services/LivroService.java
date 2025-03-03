package com.mcmn.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcmn.bookstore.domain.Livro;
import com.mcmn.bookstore.dtos.LivroDTO;
import com.mcmn.bookstore.repositories.LivroRepository;
import com.mcmn.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro create(Livro obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Livro update(Integer id, LivroDTO objDto) {
		Livro obj = findById(id);
		obj.setTitulo(objDto.getTitulo());
		obj.setTexto(objDto.getTexto());
		obj.setNomeAutor(objDto.getNomeAutor());
		obj.setCategoria(objDto.getCategoria());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
//		try {
			repository.deleteById(id);
//		} catch (DataIntegrityViolationException e) {
//			throw new com.mcmn.bookstore.services.exceptions.DataIntegrityViolationException("Livro não pode ser deletado! Possui categorias associadas!");
//		}
	}

}
