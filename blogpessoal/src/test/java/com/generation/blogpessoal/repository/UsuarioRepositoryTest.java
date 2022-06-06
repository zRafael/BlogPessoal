package com.generation.blogpessoal.repository;


import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogpessoal.model.Usuario;

//indicando que a classe UsuarioRepositoryTest é uma classe de test, que vai rodar em uma porta aleatoria a cada teste realizado
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired 
	private UsuarioRepository repository;
	
	@BeforeAll
	void start () {
		repository.save(new Usuario(0L, "Rafael da Silva", "rafael@gmail.com", "rafa1234", "https://i.imgur.com/FETvs2O.jpg", "Normal"));
		repository.save(new Usuario(0L, "Michael da Silva", "michael@gmail.com", "michael1234", "https://i.imgur.com/FETvs2O.jpg", "Normal"));
		repository.save(new Usuario(0L, "Melissa da Silva", "melissa@gmail.com", "melissa", "https://i.imgur.com/FETvs2O.jpg", "Normal"));
	}
	
	@Test
	@DisplayName("Teste que retorna um usuario")
	public void retornaUmUsuario() {
		Optional<Usuario> usuario = repository.findByUsuario("rafael@gmail.com");
		assertTrue(usuario.get().getUsuario().equals("rafael@gmail.com"));
	}
	
	@AfterAll
	public void end() {
		repository.deleteAll();
	}
}


