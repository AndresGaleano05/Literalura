package com.aluracursos.Challenge_LiterAlura;

import com.aluracursos.Challenge_LiterAlura.Principal.Principal;
import com.aluracursos.Challenge_LiterAlura.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Se implementa interfase CommandLineRunner para que ejecute lo primero que debe aparecer
public class ChallengeLiterAluraApplication implements CommandLineRunner {

	//Se inyecta la clase principal directamente porque en la clase principal se encuentra intectados las dos repositorios
	@Autowired
	private Principal principal;
	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.muestraElMenu();
	}
}

