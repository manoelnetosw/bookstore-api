package com.mcmn.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mcmn.bookstore.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String Strategy;

	@Bean
	public boolean instanciaBaseDeDados() {
		if (Strategy.equals("create")) {
			System.out.println("⚡ DevConfig: Chamando DBService...");
			this.dbService.instanciaBaseDeDados();
			System.out.println("✅ DevConfig: DBService chamado com sucesso!");
		}
		return false;
	}
}
