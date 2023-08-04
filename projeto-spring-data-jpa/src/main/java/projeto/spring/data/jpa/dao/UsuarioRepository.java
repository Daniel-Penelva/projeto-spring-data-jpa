package projeto.spring.data.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.spring.data.jpa.model.UsuarioSpringData;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioSpringData, Long>{
	
	// Consulta personalizada utilizando um parâmetros
	@Query(value = "select u from UsuarioSpringData u where u.nome like %?1%")
	public List<UsuarioSpringData> buscarPorNome(String nome);
	
	
	// Consulta personalizada utilizando dois parâmetros
	@Query(value = "select u from UsuarioSpringData u where u.nome like %?1% and u.idade = ?2")
	public List<UsuarioSpringData> buscarPorNomeEIdade(String nome, int idade);
	
}
