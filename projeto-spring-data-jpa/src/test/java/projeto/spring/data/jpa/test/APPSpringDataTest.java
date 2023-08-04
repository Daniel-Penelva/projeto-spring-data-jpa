package projeto.spring.data.jpa.test;

import java.util.Optional;

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
	
	//@Test
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
	
	@Test
	public void testeConsultarPorId() {
		
		//O método .findById() é do tipo Optional
		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(3L);
		
		if(usuario.isPresent()) {
		
		// O método get() retorna o próprio usuário com todas as suas propriedades
	    System.out.println("Dados do usuario: ");
	    System.out.println("Id: " + usuario.get().getId());
	    System.out.println("Nome: " + usuario.get().getNome());
	    System.out.println("Login: " + usuario.get().getLogin());
	    System.out.println("Senha: " + usuario.get().getSenha());
	    System.out.println("Email: " + usuario.get().getEmail());
	    System.out.println("Idade: " + usuario.get().getIdade());
	    
		}else {
		System.out.println("Usuario inexistente");
		}
	}
}
