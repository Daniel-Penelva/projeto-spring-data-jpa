package projeto.spring.data.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone implements Serializable{

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	private String tipo;
	
	@Column(nullable = false)
	private String numero;
	
	// Muitos telefones para uma pessoa
	@ManyToOne(optional = false)
	private UsuarioSpringData usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setUsuario(UsuarioSpringData usuario) {
		this.usuario = usuario;
	}
	
	public UsuarioSpringData getUsuario() {
		return usuario;
	}
}
