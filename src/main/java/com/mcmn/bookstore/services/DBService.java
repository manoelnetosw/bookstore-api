package com.mcmn.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcmn.bookstore.domain.Categoria;
import com.mcmn.bookstore.domain.Livro;
import com.mcmn.bookstore.repositories.CategoriaRepository;
import com.mcmn.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {

		System.out.println("⚡ DBService: Populando banco de dados...");

		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Games", "Jogos Diversos");
		Categoria cat3 = new Categoria(null, "Auto", "Carros e Motos");
		Categoria cat4 = new Categoria(null, "Home", "Variados");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Ferrari", "Augustini Ferrari", "Corridas e campeonatos", cat3);
		Livro l3 = new Livro(null, "Moto GP", "Robert Martin", "Modo de pilotagem", cat3);
		Livro l4 = new Livro(null, "TI Simplificado", "Robert Martin", "Pensando rapido", cat1);
		Livro l5 = new Livro(null, "MMO RPG", "Robert Martin", "Best games world", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l4));
		cat2.getLivros().addAll(Arrays.asList(l5));
		cat3.getLivros().addAll(Arrays.asList(l2, l3));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

		System.out.println("✅ DBService: Objetos inseridos no banco de dados!");
	}
}
