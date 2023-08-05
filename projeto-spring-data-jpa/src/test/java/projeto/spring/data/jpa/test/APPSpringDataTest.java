package projeto.spring.data.jpa.test;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.jpa.dao.TelefoneRepository;
import projeto.spring.data.jpa.dao.UsuarioRepository;
import projeto.spring.data.jpa.model.Telefone;
import projeto.spring.data.jpa.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class APPSpringDataTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	// @Test
	public void testeInsert() {

		UsuarioSpringData usuario = new UsuarioSpringData();
		usuario.setLogin("hugo");
		usuario.setSenha("123");
		usuario.setNome("Hugo");
		usuario.setEmail("hugo@gmail.com");
		usuario.setIdade(34);

		Telefone telefone = new Telefone();
		telefone.setTipo("celular");
		telefone.setNumero("95577-8932");
		telefone.setUsuario(usuario);

		usuarioRepository.save(usuario);
		telefoneRepository.save(telefone);

		System.out.println("Usuário e telefone salvo com sucesso!");

		System.out.println("Usuários cadastrados -> " + usuarioRepository.count());
	}

	//@Test
	public void testeConsultarPorId() {

		// O método .findById() é do tipo Optional
		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(1L);

		if (usuario.isPresent()) {

			// O método get() retorna o próprio usuário com todas as suas propriedades
			System.out.println("Dados do usuario: ");
			System.out.println("Id: " + usuario.get().getId());
			System.out.println("Nome: " + usuario.get().getNome());
			System.out.println("Login: " + usuario.get().getLogin());
			System.out.println("Senha: " + usuario.get().getSenha());
			System.out.println("Email: " + usuario.get().getEmail());
			System.out.println("Idade: " + usuario.get().getIdade());

			for (Telefone telefone : usuario.get().getTelefones()) {
				System.out.println("Telefones: ");
				System.out.println("Tipo: " + telefone.getTipo() + " Número: " + telefone.getNumero());
				System.out.println("Usuário: " + telefone.getUsuario().getNome());
			}

		} else {
			System.out.println("Usuario inexistente");
		}
	}

	@Test
	public void consultarTodos() {

		Iterable<UsuarioSpringData> listaUsu = usuarioRepository.findAll();
		Iterable<Telefone> listaTel = telefoneRepository.findAll();

		for (UsuarioSpringData usuarioSpringData : listaUsu) {
			System.out.println("Dados do usuario: ");
			System.out.println("Id: " + usuarioSpringData.getId());
			System.out.println("Nome: " + usuarioSpringData.getNome());
			System.out.println("Login: " + usuarioSpringData.getLogin());
			System.out.println("Senha: " + usuarioSpringData.getSenha());
			System.out.println("Email: " + usuarioSpringData.getEmail());
			System.out.println("Idade: " + usuarioSpringData.getIdade());

			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println();
		}
			
		for (Telefone telefone : listaTel) {

			System.out.println("Dados Telefone: ");
			System.out.println("Id do telefone: " + +telefone.getId());
			System.out.println("Tipo: " + telefone.getTipo());
			System.out.println("Número: " + telefone.getNumero());
			System.out.println("telefone pertence ao " + telefone.getUsuario().getNome());

			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println();
		}
	}

	// @Test
	public void testeUpdate() {

		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(8L);

		if (usuario.isPresent()) {

			UsuarioSpringData usuAtualizar = usuario.get();

			// Valor a ser modificado
			usuAtualizar.setNome("Dandara");
			usuAtualizar.setLogin("dandara");
			usuAtualizar.setEmail("dandara@gmail.com");
			usuAtualizar.setIdade(15);

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

	// @Test
	public void testeDelete() {
		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(2L);

		if (usuario.isPresent()) {
			usuarioRepository.delete(usuario.get());

			System.out.println("Usuário deletado com sucesso!");
		} else {
			System.out.println("Usuario inexistente");
		}
	}

	// @Test
	public void testeDeletePorId() {

		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(41L);

		if (usuario.isPresent()) {
			usuarioRepository.deleteById(usuario.get().getId());

			System.out.println("Usuário deletado com sucesso!");
		} else {
			System.out.println("Usuario inexistente");
		}
	}

	// @Test
	public void testeBuscarPorNome() {

		List<UsuarioSpringData> listUsu = usuarioRepository.buscarPorNome("Da");

		if (listUsu.size() > 0) {

			System.out.println("Existe " + usuarioRepository.count() + " ao todo nessa lista com esse nome");

			for (UsuarioSpringData usuarioSpringData : listUsu) {
				System.out.println("Dados do usuario: ");
				System.out.println("Id: " + usuarioSpringData.getId());
				System.out.println("Nome: " + usuarioSpringData.getNome());
				System.out.println("Login: " + usuarioSpringData.getLogin());
				System.out.println("Senha: " + usuarioSpringData.getSenha());
				System.out.println("Email: " + usuarioSpringData.getEmail());
				System.out.println("Idade: " + usuarioSpringData.getIdade());
				System.out.println("------------------------------------------------");
			}
		} else {
			System.out.println("Não existe registro com o nome desse usuário!");
		}
	}

	// @Test
	public void testeBuscarPorNomeEIdade() {

		List<UsuarioSpringData> listUsu = usuarioRepository.buscarPorNomeEIdade("Da", 18);

		if (listUsu.size() > 0) {

			System.out.println("Existe " + usuarioRepository.count() + " ao todo nessa lista com esse nome");

			for (UsuarioSpringData usuarioSpringData : listUsu) {
				System.out.println("Dados do usuario: ");
				System.out.println("Id: " + usuarioSpringData.getId());
				System.out.println("Nome: " + usuarioSpringData.getNome());
				System.out.println("Login: " + usuarioSpringData.getLogin());
				System.out.println("Senha: " + usuarioSpringData.getSenha());
				System.out.println("Email: " + usuarioSpringData.getEmail());
				System.out.println("Idade: " + usuarioSpringData.getIdade());
				System.out.println("------------------------------------------------");
			}
		} else {
			System.out.println("Não existe registro com o nome e idade desse usuário!");
		}
	}

	// @Test
	public void testBuscarPorNomeParam() {

		UsuarioSpringData usuario = usuarioRepository.buscarPorNomeParam("Daniel");

		if (usuario != null) {

			System.out.println("Dados do usuario: ");
			System.out.println("Id: " + usuario.getId());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Login: " + usuario.getLogin());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("Idade: " + usuario.getIdade());

		} else {
			System.out.println("Não existe registro com o nome e idade desse usuário!");
		}
	}

	// @Test
	public void testeDeletePorNome() {

		usuarioRepository.deletePorNome("Amanda");
		System.out.println("Usuario deletado com sucesso!");
	}

	// @Test
	public void testeUpdatePorNome() {
		usuarioRepository.updatePorNome("daniel@gmail.com", "Daniel");
		System.out.println("Usuário alterado com sucesso!");
	}

	// @Test
	public void testeInsertTelefone() {

		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(5L);
		Telefone telefone = new Telefone();

		telefone.setTipo("celular");
		telefone.setNumero("98865-99085");
		telefone.setUsuario(usuario.get());

		telefoneRepository.save(telefone);

		System.out.println("Telefone salvo com sucesso");

		System.out.println("Valor de registro de telefone -> " + telefoneRepository.count());
	}

}
