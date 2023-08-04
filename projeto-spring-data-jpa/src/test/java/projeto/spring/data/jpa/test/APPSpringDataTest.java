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
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class APPSpringDataTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	//@Test
	public void testeInsert() {

		UsuarioSpringData usuario = new UsuarioSpringData();
		usuario.setLogin("daiane");
		usuario.setSenha("123");
		usuario.setNome("Daiane");
		usuario.setEmail("daiane@gmail.com");
		usuario.setIdade(27);

		usuarioRepository.save(usuario);

		System.out.println("Usuário salvo com sucesso!");

		System.out.println("Usuários cadastrados -> " + usuarioRepository.count());
	}

	// @Test
	public void testeConsultarPorId() {

		// O método .findById() é do tipo Optional
		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(3L);

		if (usuario.isPresent()) {

			// O método get() retorna o próprio usuário com todas as suas propriedades
			System.out.println("Dados do usuario: ");
			System.out.println("Id: " + usuario.get().getId());
			System.out.println("Nome: " + usuario.get().getNome());
			System.out.println("Login: " + usuario.get().getLogin());
			System.out.println("Senha: " + usuario.get().getSenha());
			System.out.println("Email: " + usuario.get().getEmail());
			System.out.println("Idade: " + usuario.get().getIdade());

		} else {
			System.out.println("Usuario inexistente");
		}
	}

	// @Test
	public void consultarTodos() {

		Iterable<UsuarioSpringData> listaUsu = usuarioRepository.findAll();

		for (UsuarioSpringData usuarioSpringData : listaUsu) {
			System.out.println("Dados do usuario: ");
			System.out.println("Id: " + usuarioSpringData.getId());
			System.out.println("Nome: " + usuarioSpringData.getNome());
			System.out.println("Login: " + usuarioSpringData.getLogin());
			System.out.println("Senha: " + usuarioSpringData.getSenha());
			System.out.println("Email: " + usuarioSpringData.getEmail());
			System.out.println("Idade: " + usuarioSpringData.getIdade());
			System.out.println("------------------------------------------------");
		}
	}

	// @Test
	public void testeUpdate() {

		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(10L);

		if (usuario.isPresent()) {

			UsuarioSpringData usuAtualizar = usuario.get();

			// Valor a ser modificado
			usuAtualizar.setNome("Jair Bolsonaro");
			usuAtualizar.setLogin("bolsonaro");
			usuAtualizar.setEmail("bo4@gmail.com");

			// Salvar no banco de dados
			usuarioRepository.save(usuAtualizar);

			System.out.println("Usuário modificado com sucesso!");

		} else {
			System.out.println("Usuario inexistente");
		}
	}

	// @Test
	public void testeDeleteSimples() {
		usuarioRepository.deleteById(2L);
		System.out.println("Usuário deletado com sucesso!");
	}

	//@Test
	public void testeDelete() {
		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(2L);

		if (usuario.isPresent()) {
			usuarioRepository.delete(usuario.get());

			System.out.println("Usuário deletado com sucesso!");
		} else {
			System.out.println("Usuario inexistente");
		}
	}

	@Test
	public void testeDeletePorId() {

		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(41L);

		if (usuario.isPresent()) {
			usuarioRepository.deleteById(usuario.get().getId());

			System.out.println("Usuário deletado com sucesso!");
		} else {
			System.out.println("Usuario inexistente");
		}
	}
}
