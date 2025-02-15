package com.mcmn.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mcmn.bookstore.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instanciaBaseDeDados() {
        System.out.println("⚡ TestConfig: Chamando DBService...");
        dbService.instanciaBaseDeDados();
        System.out.println("✅ TestConfig: DBService chamado com sucesso!");
        return true;
    }
}
