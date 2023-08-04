package projeto.spring.data.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.spring.data.jpa.model.UsuarioSpringData;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioSpringData, Long>{
	
}
