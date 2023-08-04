package projeto.spring.data.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projeto.spring.data.jpa.model.UsuarioSpringData;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioSpringData, Long>{
	
	// Consulta personalizada utilizando um parâmetros
	@Query(value = "select u from UsuarioSpringData u where u.nome like %?1%")
	public List<UsuarioSpringData> buscarPorNome(String nome);
	
	
	// Consulta personalizada utilizando dois parâmetros
	@Query(value = "select u from UsuarioSpringData u where u.nome like %?1% and u.idade = ?2")
	public List<UsuarioSpringData> buscarPorNomeEIdade(String nome, int idade);
	
	
	// Realizando consultas por meio de parâmetro
	@Query(value = "select u from UsuarioSpringData u where u.nome = :paramnome")
	public UsuarioSpringData buscarPorNomeParam(@Param("paramnome") String paramnome);
	
	@Modifying
	@Transactional
	@Query(value = "delete from UsuarioSpringData u where u.nome = ?1")
	public void deletePorNome(String nome);
	
}
