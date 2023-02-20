package com.example.CRUDSpringBoot;

import com.example.CRUDSpringBoot.entidades.Usuario;
import com.example.CRUDSpringBoot.repository.UsuarioRepository;
import jakarta.persistence.Entity;
import org.apache.tomcat.util.buf.UEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CrudSpringBootApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;
	@Test
	public void crearUsuario() {
	Usuario usr = new Usuario();
	usr.setId(5);
	usr.setNombre("otraPrueba");
	usr.setCorreo("prueba@gmail.com");
	usr.setContraseña(encoder.encode("555"));
	Usuario retorno =	usuarioRepo.save(usr);

		assertTrue(retorno.getContraseña().equalsIgnoreCase(usr.getContraseña()));
		assertTrue(retorno.getCorreo().equalsIgnoreCase(usr.getCorreo()));

	}

}
