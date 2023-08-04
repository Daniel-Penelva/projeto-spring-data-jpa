package projeto.spring.data.jpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.jpa.dao.UsuarioRepository;
import projeto.spring.data.jpa.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class APPSpringDataTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void testeInsert() {
		
		UsuarioSpringData usuario = new UsuarioSpringData();
		usuario.setLogin("fabiana");
		usuario.setSenha("123");
		usuario.setNome("Fabiana");
		usuario.setEmail("fi4.andrade@gmail.com");
		usuario.setIdade(34);
		
		usuarioRepository.save(usuario);
		
		System.out.println("Usuário salvo com sucesso!");
		
		System.out.println("Usuários cadastrados -> " + usuarioRepository.count());
	}
}
