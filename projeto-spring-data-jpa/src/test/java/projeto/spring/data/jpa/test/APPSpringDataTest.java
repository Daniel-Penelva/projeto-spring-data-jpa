package projeto.spring.data.jpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.jpa.dao.UsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class APPSpringDataTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void testeInsert() {
		System.out.println("Iniciou Spring com sucesso!");
	}
}
