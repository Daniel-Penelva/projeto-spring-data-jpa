# Documentação do Projeto Usando Spring Data JPA e JUnit

Este é um guia de documentação para um projeto que utiliza o Spring Data JPA e o JUnit. O Spring Data JPA é uma parte do ecossistema Spring que facilita a interação com bancos de dados relacionais, enquanto o JUnit é uma estrutura de teste unitário amplamente usada para testar código Java.

## Spring Data JPA

O Spring Data JPA é uma extensão do Spring Framework que simplifica a implementação de repositórios baseados em JPA (Java Persistence API) em aplicativos Spring. Com o Spring Data JPA, você pode criar repositórios de dados de maneira fácil e eficiente, permitindo que você execute operações de leitura e gravação no banco de dados de forma simples e elegante.

## JUnit

O JUnit é uma estrutura de teste unitário para a linguagem de programação Java. Ele fornece uma maneira simples e eficaz de testar suas classes e métodos Java para garantir que eles funcionem conforme o esperado. O JUnit ajuda a automatizar testes de unidade, identificar problemas de código e melhorar a qualidade do software.

Neste guia de documentação, exploraremos como usar o Spring Data JPA para criar repositórios de dados e como usar o JUnit para escrever testes unitários eficazes para seu código Java.

Continue lendo para saber mais sobre as classes e recursos específicos que serão abordados neste projeto.

##Classe UsuarioSpringData

Esta classe representa um modelo de dados de usuário com atributos como login, senha, nome, email, idade e uma lista de telefones associados.

```java
package projeto.spring.data.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UsuarioSpringData implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String login;
	private String senha;
	private String nome;
	private String email;
	private int idade;
	
    @OneToMany(mappedBy = "usuario",  orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Telefone> telefones;

	// Getters e setters para os atributos
}
```

## Classe Telefone

Esta classe representa um modelo de dados de telefone com atributos como tipo, numero e uma associação bidirecional com a classe UsuarioSpringData.

```java
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
	
	@ManyToOne(optional = false)
	private UsuarioSpringData usuario;

	// Getters e setters para os atributos
}
```

## Diagrama de Classe do Sistema de Gerenciamento de Usuários

![Diagrama de Classe](file://C:/Users/d4nan/git/repository18/projeto-spring-data-jpa/src/main/resources/img/diagramaClasse.jpg)

**Descrição do Diagrama:**

- **Classe `UsuarioSpringData`:** Representa um usuário no sistema. Contém informações como ID, login, senha, nome, email, idade e uma lista de telefones associados a esse usuário.

- **Classe `Telefone`:** Representa um telefone associado a um usuário. Armazena informações como ID, tipo (por exemplo, celular ou fixo) e número. Cada telefone está relacionado a um único usuário.

Este diagrama de classe fornece uma visão clara das entidades principais do sistema e suas relações, facilitando a compreensão da estrutura de dados.

# Spring Data JPA - Visão Geral e Principais Métodos

O Spring Data JPA é uma parte do ecossistema Spring que facilita o acesso a dados em aplicativos Java baseados em JPA (Java Persistence API). Ele fornece uma abordagem simplificada para interagir com bancos de dados relacionais, permitindo que você escreva consultas e manipule entidades persistentes de maneira mais eficiente.

## Resumo

O Spring Data JPA é uma ferramenta poderosa para simplificar o acesso a dados em aplicativos Java. Ele fornece uma variedade de métodos úteis para interagir com bancos de dados de maneira eficiente. Além disso, permite a criação de consultas personalizadas para atender às necessidades específicas do seu aplicativo.

Esta documentação fornece uma visão geral dos principais métodos oferecidos pelo Spring Data JPA e como usá-los. Para obter detalhes adicionais, consulte a documentação oficial do Spring Data JPA.

## Principais Métodos do Spring Data JPA

O Spring Data JPA oferece uma série de métodos padrão que podem ser usados para executar operações comuns de acesso a dados, como criar, ler, atualizar e excluir registros em um banco de dados. Aqui estão alguns dos principais métodos disponíveis:

### `save(S)` e `saveAll(Iterable<S>)`

- `save(S entity)`: Salva uma entidade no banco de dados. Se a entidade já existir no banco de dados, ela será atualizada. Caso contrário, uma nova entidade será criada.

- `saveAll(Iterable<S> entities)`: Salva uma coleção de entidades no banco de dados. Este método é usado para inserir várias entidades de uma vez.

### `findById(ID)`

- `findById(ID id)`: Retorna uma entidade com base no seu ID. Se a entidade não existir, é retornado um valor vazio (nulo).

### `findAll()`

- `findAll()`: Retorna todas as entidades presentes no banco de dados.

### `count()`

- `count()`: Retorna o número total de registros no banco de dados para uma entidade específica.

### `deleteById(ID)`

- `deleteById(ID id)`: Exclui uma entidade com base no seu ID.

### `deleteAll()`

- `deleteAll()`: Exclui todos os registros de uma entidade no banco de dados.

### `findBy{Property}`

- `findBy{Property}(Type property)`: Permite buscar entidades com base em uma propriedade específica. O Spring Data JPA gera consultas automaticamente com base no nome da propriedade e do tipo.

### `findBy{Property}And{Property}`

- `findBy{Property}And{Property}(Type property1, Type property2)`: Permite buscar entidades com base em duas propriedades específicas. Você pode combinar várias propriedades em uma consulta.

### `findBy{Property}Or{Property}`

- `findBy{Property}Or{Property}(Type property1, Type property2)`: Permite buscar entidades com base em duas propriedades específicas. Esta consulta retornará resultados se pelo menos uma das propriedades coincidir.

### `findFirstBy{Property}` e `findTopBy{Property}`

- `findFirstBy{Property}(Type property)`: Retorna a primeira entidade encontrada com base em uma propriedade específica.

- `findTopBy{Property}(Type property)`: Similar ao `findFirstBy{Property}`, retorna a primeira entidade encontrada com base em uma propriedade específica.

### `findDistinctBy{Property}`

- `findDistinctBy{Property}(Type property)`: Retorna resultados distintos com base em uma propriedade específica.

### `findBy{Property}OrderBy{AnotherProperty}`

- `findBy{Property}OrderBy{AnotherProperty}(Type property1, Type property2)`: Permite buscar entidades com base em uma propriedade específica e ordenar os resultados por outra propriedade.

### `findBy{Property}IgnoreCase`

- `findBy{Property}IgnoreCase(Type property)`: Realiza uma consulta insensível a maiúsculas e minúsculas em uma propriedade específica.

### `delete` e `deleteAllInBatch`

- `delete(Entity entity)`: Exclui uma entidade específica.

- `deleteAll()`: Exclui todos os registros de uma entidade no banco de dados.

- `deleteAllInBatch()`: Exclui todos os registros de uma entidade no banco de dados em lote (uma única consulta SQL).

### `findBy{Property}NotNull` e `findBy{Property}Null`

- `findBy{Property}NotNull()`: Retorna entidades onde uma propriedade específica não é nula.

- `findBy{Property}Null()`: Retorna entidades onde uma propriedade específica é nula.


## Interface UsuarioRepository

A interface `UsuarioRepository` faz parte do ecossistema Spring Data JPA e é responsável por definir métodos de acesso a dados para a entidade `UsuarioSpringData`. Esta interface estende a interface `CrudRepository`, fornecendo operações CRUD (Create, Read, Update, Delete) básicas para a entidade.

### Consultas Personalizadas

Além  das operações CRUD padrão (métodos padrão), o Spring Data JPA permite definir consultas personalizadas usando a anotação `@Query`. Você pode escrever consultas em JPQL (Java Persistence Query Language) ou SQL nativo e mapeá-las para métodos de repositório. A interface `UsuarioRepository` define consultas personalizadas utilizando a anotação `@Query`. 

```java
package projeto.spring.data.jpa.dao;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projeto.spring.data.jpa.model.UsuarioSpringData;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioSpringData, Long>{
	
	@Query(value = "select u from UsuarioSpringData u where u.nome like %?1%")
	public List<UsuarioSpringData> buscarPorNome(String nome);
	
	@Query(value = "select u from UsuarioSpringData u where u.nome like %?1% and u.idade = ?2")
	public List<UsuarioSpringData> buscarPorNomeEIdade(String nome, int idade);
	
	@Lock(LockModeType.READ)
	@Query(value = "select u from UsuarioSpringData u where u.nome = :paramnome")
	public UsuarioSpringData buscarPorNomeParam(@Param("paramnome") String paramnome);
	
	@Modifying
	@Transactional
	@Query(value = "delete from UsuarioSpringData u where u.nome = ?1")
	public void deletePorNome(String nome);
	
	
	@Modifying
	@Transactional
	@Query(value = "update UsuarioSpringData u set u.email = ?1 where u.nome = ?2")
	public void updatePorNome(String email, String nome);
	
}

```

### Método `buscarPorNome`

- Este método permite buscar usuários cujo nome contenha uma determinada sequência de caracteres. O parâmetro nome é usado na consulta para filtrar os resultados. 

```java
@Query(value = "select u from UsuarioSpringData u where u.nome like %?1%")
public List<UsuarioSpringData> buscarPorNome(String nome);
```

### Método `buscarPorNomeEIdade`

- Este método permite buscar usuários cujo nome contenha uma determinada sequência de caracteres e que tenham uma idade específica. Os parâmetros nome e idade são usados na consulta para filtrar os resultados.

```java
@Query(value = "select u from UsuarioSpringData u where u.nome like %?1% and u.idade = ?2")
public List<UsuarioSpringData> buscarPorNomeEIdade(String nome, int idade);
```

### Método `buscarPorNomeParam`

- Este método permite buscar um usuário pelo nome usando um parâmetro nomeado (paramnome). A anotação @Lock especifica que a consulta deve ser executada com um bloqueio de leitura e que tenham uma idade específica. Os parâmetros nome e idade são usados na consulta para filtrar os resultados.

```java
@Lock(LockModeType.READ)
@Query(value = "select u from UsuarioSpringData u where u.nome = :paramnome")
public UsuarioSpringData buscarPorNomeParam(@Param("paramnome") String paramnome);
```

### Método `deletePorNome`

- Este método permite excluir usuários com base em seus nomes. A anotação @Modifying indica que esta consulta é uma operação de modificação, e a anotação @Transactional garante que a operação seja executada em uma transação.

```java
@Modifying
@Transactional
@Query(value = "delete from UsuarioSpringData u where u.nome = ?1")
public void deletePorNome(String nome);
```

### Método `updatePorNome`

- Este método permite atualizar o email de um usuário com base em seu nome. A anotação @Modifying indica que esta consulta é uma operação de modificação, e a anotação @Transactional garante que a operação seja executada em uma transação.

```java
@Modifying
@Transactional
@Query(value = "update UsuarioSpringData u set u.email = ?1 where u.nome = ?2")
public void updatePorNome(String email, String nome);
```

## Interface TelefoneRepository

A interface `TelefoneRepository` é uma parte do Spring Data JPA, que fornece uma maneira simplificada de realizar operações CRUD (Create, Read, Update, Delete) em entidades relacionadas a telefones.

```java
package projeto.spring.data.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.spring.data.jpa.model.Telefone;

@Repository
public interface TelefoneRepository extends CrudRepository<Telefone, Long>{

}
```

### Métodos Herdados

Esta interface herda métodos do `CrudRepository`, que incluem operações básicas de banco de dados, como salvar, recuperar, atualizar e excluir registros.

- `save(S entity)`: Salva uma entidade de telefone no banco de dados.
- `findById(ID id)`: Recupera uma entidade de telefone com base no ID fornecido.
- `existsById(ID id)`: Verifica se uma entidade de telefone com o ID fornecido existe no banco de dados.
- `findAll()`: Recupera todas as entidades de telefone no banco de dados.
- `findAllById(Iterable<ID> ids)`: Recupera uma lista de entidades de telefone com base em uma lista de IDs.
- `count()`: Retorna o número total de entidades de telefone no banco de dados.
- `deleteById(ID id)`: Exclui uma entidade de telefone com base no ID fornecido.
- `delete(T entity)`: Exclui uma entidade de telefone específica do banco de dados.

## JUnit - Framework de Teste para Java

### Introdução

JUnit é um framework de teste de código aberto amplamente utilizado para testar aplicativos Java. Ele fornece uma estrutura para escrever e executar testes unitários automatizados, garantindo que o código funcione conforme o esperado. Os testes unitários são uma parte essencial do desenvolvimento de software, pois ajudam a identificar problemas e garantir a integridade do código.

## Principais Características

### Anotações

O JUnit utiliza anotações para marcar métodos de teste. Alguns exemplos de anotações JUnit incluem:

- `@Test`: Indica que um método é um método de teste.
- `@Before`: Executado antes de cada método de teste.
- `@After`: Executado após cada método de teste.
- `@BeforeClass`: Executado antes da execução de todos os métodos de teste em uma classe.
- `@AfterClass`: Executado após a execução de todos os métodos de teste em uma classe.

### Asserts

O JUnit fornece um conjunto de métodos de assert para verificar se as condições especificadas são atendidas durante a execução do teste. Alguns exemplos de métodos de assert incluem:

- `assertEquals(expected, actual)`: Verifica se dois valores são iguais.
- `assertNotEquals(expected, actual)`: Verifica se dois valores são diferentes.
- `assertTrue(condition)`: Verifica se uma condição é verdadeira.
- `assertFalse(condition)`: Verifica se uma condição é falsa.
- `assertNull(object)`: Verifica se um objeto é nulo.
- `assertNotNull(object)`: Verifica se um objeto não é nulo.

### Test Runners

O JUnit oferece suporte a diferentes test runners que permitem a execução de testes de diferentes maneiras. Alguns test runners populares incluem:

- `JUnitCore`: Permite a execução de testes a partir da linha de comando.
- `JUnit Vintage`: Oferece suporte à execução de testes JUnit 3 e JUnit 4.
- `JUnit Jupiter`: Introduzido no JUnit 5, fornece recursos avançados, como extensibilidade e parametrização.

### Como Usar o JUnit

Para começar a usar o JUnit em seu projeto Java, siga estas etapas:

1. Adicione a dependência do JUnit ao seu projeto. Isso pode ser feito por meio de uma ferramenta de gerenciamento de dependências, como o Maven ou o Gradle.

2. Crie classes de teste para suas classes de código. Essas classes de teste devem conter métodos de teste anotados com `@Test`.

3. Escreva os testes para suas classes de código usando os métodos de assert fornecidos pelo JUnit.

4. Execute os testes usando um ambiente de execução apropriado, como uma IDE de desenvolvimento ou uma ferramenta de build.

5. Analise os resultados dos testes para identificar problemas e garantir que o código funcione corretamente.

### Benefícios do JUnit

- Automatização: O JUnit permite a automação de testes, economizando tempo e esforço.
- Confiabilidade: Testes unitários regulares ajudam a identificar problemas rapidamente, melhorando a confiabilidade do código.
- Documentação: Os testes servem como documentação viva do comportamento esperado do código.
- Facilidade de Integração: O JUnit pode ser facilmente integrado a várias ferramentas de desenvolvimento.

O JUnit é uma ferramenta essencial para garantir a qualidade do código em projetos Java e é amplamente adotado pela comunidade de desenvolvedores.

## Classe APPSpringDataTest

Nesta classe de teste JUnit, estamos testando as operações CRUD em uma aplicação Spring Data JPA. 

```java
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

	@Test
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

	@Test
	public void testeConsultarPorId() {

		Optional<UsuarioSpringData> usuario = usuarioRepository.findById(1L);

		if (usuario.isPresent()) {
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

	@Test
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

	@Test
	public void testeDeleteSimples() {
		usuarioRepository.deleteById(2L);
		System.out.println("Usuário deletado com sucesso!");
	}

	@Test
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

	@Test
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

	@Test
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

	@Test
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

	@Test
	public void testeDeletePorNome() {

		usuarioRepository.deletePorNome("Amanda");
		System.out.println("Usuario deletado com sucesso!");
	}

	@Test
	public void testeUpdatePorNome() {
		usuarioRepository.updatePorNome("daniel@gmail.com", "Daniel");
		System.out.println("Usuário alterado com sucesso!");
	}

	@Test
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
```

Vamos explicar os principais elementos dessa classe:

### Anotações JUnit

- `@Test`: Anotação usada para marcar os métodos de teste. Os métodos marcados com `@Test` são executados pelo JUnit durante a execução dos testes.

- `@RunWith(SpringJUnit4ClassRunner.class)`: Esta anotação define o `Runner` que será usado para executar os testes. Neste caso, estamos usando o `SpringJUnit4ClassRunner`, que é específico para integração com o Spring Framework.

- `@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })`: Define o local dos arquivos de configuração do Spring. Isso permite que o Spring carregue o contexto de aplicação necessário para os testes.

## Injeção de Dependência

- `@Autowired`: Esta anotação é usada para injetar instâncias de objetos gerenciados pelo Spring, como repositórios (`UsuarioRepository` e `TelefoneRepository` neste caso). Isso permite que os testes interajam com esses componentes como se estivessem sendo usados em um ambiente real.

## Métodos de Teste

A classe de teste contém vários métodos de teste, cada um focando em testar uma operação específica. Alguns dos principais métodos de teste são:

- `testeInsert()`: Testa a inserção de um novo usuário e telefone no banco de dados.

- `testeConsultarPorId()`: Testa a consulta de um usuário por ID e imprime seus detalhes, incluindo os telefones associados.

- `consultarTodos()`: Consulta e exibe todos os usuários e telefones cadastrados no banco de dados.

- `testeUpdate()`: Testa a atualização de informações de um usuário existente.

- `testeDeleteSimples()`: Testa a exclusão de um usuário por ID.

- `testeDelete()`: Testa a exclusão de um usuário existente.

- `testeDeletePorId()`: Testa a exclusão de um usuário por ID.

- `testeBuscarPorNome()`: Testa a consulta de usuários por nome e exibe os resultados.

- `testeBuscarPorNomeEIdade()`: Testa a consulta de usuários por nome e idade e exibe os resultados.

- `testBuscarPorNomeParam()`: Testa a consulta de um usuário por nome usando um método personalizado.

- `testeDeletePorNome()`: Testa a exclusão de um usuário por nome.

- `testeUpdatePorNome()`: Testa a atualização do email de um usuário por nome.

- `testeInsertTelefone()`: Testa a inserção de um telefone associado a um usuário existente.

Cada método de teste executa uma operação específica e verifica se o resultado está de acordo com o esperado.

Os testes são essenciais para garantir que as operações CRUD funcionem corretamente em sua aplicação Spring Data JPA e que não ocorram regressões ao longo do desenvolvimento.

## Configuração spring-config.xml para o Projeto Spring Data JPA

Neste documento, vamos explicar as configurações contidas no arquivo XML de configuração Spring para um projeto Spring Data JPA. Este arquivo é usado para configurar o ambiente de aplicação, incluindo conexão com banco de dados, configurações JPA e gerenciamento de transações.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:jpa="http://www.springframework.org/schema/data/jpa"
	xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context-3.0.xsd
        http://www.springframework.org/schema/data/jpa
        http://www.springframework.org/schema/data/jpa/spring-jpa.xsd"
	default-lazy-init="true">
	
	 <!-- Ativa recursos automáticos no Spring como Injeção de Dependecia por anotações -->
	<context:annotation-config />
	<context:component-scan base-package="projeto.spring.data.jpa.model" />
	
	<!-- Define o DataSource e a conexão com o banco de dados -->
     <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
         <property name="driverClassName" value="org.postgresql.Driver"/>
         <property name="url" value="jdbc:postgresql://localhost:5433/spring-data-jpa"/>
         <property name="username" value="postgres"/>
         <property name="password" value="admin"/>
     </bean>
	
	<!-- Define as configurações do JPA -->
	<bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean" scope="singleton">
		<property name="dataSource" ref="dataSource"/>
		<property name="jpaVendorAdapter">
			<bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
				<property name="database" value="POSTGRESQL"/>
				<property name="generateDdl" value="true"/> <!-- Gerar as tabelas no banco -->
			</bean>
		</property>
		<property name="persistenceUnitName" value="projeto-spring-data-jpa"/>
		
		<!-- Adicionar a propriedade hibernate.dialect aqui -->
        <property name="jpaPropertyMap">
            <map>
                <entry key="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
            </map>
        </property>
	</bean>
	
	<!-- Ativa o controle transacional -->
	<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager" scope="singleton">
		<property name="entityManagerFactory" ref="entityManagerFactory"/>
	</bean>
	
	<!-- Ativa os recursos para os Repository de persistência -->
	<jpa:repositories base-package="projeto.spring.data.jpa.dao" />
</beans>
```

### `<context:annotation-config /> e <context:component-scan>`

- Essas tags habilitam recursos automáticos do Spring, como Injeção de Dependência por meio de anotações. O component-scan define o pacote base para escanear componentes Spring, como entidades JPA.


### `<bean id="dataSource">`

- Esta tag define o DataSource e a conexão com o banco de dados. Ela configura as informações necessárias, como URL, nome de usuário e senha.

### `<bean id="entityManagerFactory">`

- Aqui, foi configurado o EntityManagerFactory, que é essencial para a persistência JPA. Este bean utiliza o dataSource definido anteriormente e configura detalhes como o adaptador JPA (Hibernate, neste caso), a unidade de persistência e a propriedade hibernate.dialect.

### `<bean id="transactionManager">`

- Esta tag cria o gerenciador de transações JPA, vinculando-o ao entityManagerFactory. Ele permite o controle de transações para operações no banco de dados.

### `<jpa:repositories>`

- Esta tag habilita os recursos dos repositórios Spring Data JPA, especificando o pacote base para procurar interfaces de repositório.

## Configuração persistência.xml para o Projeto Spring Data JPA

Neste documento, vamos explicar as configurações contidas no arquivo XML de configuração de persistência para um projeto Spring Data JPA. Este arquivo é usado para definir as classes de entidades JPA que serão gerenciadas pela unidade de persistência.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
    <persistence-unit name="projeto-spring-data-jpa">
        <class>projeto.spring.data.jpa.model.UsuarioSpringData</class>
        <class>projeto.spring.data.jpa.model.Telefone</class>
    </persistence-unit>
</persistence>
```

### `<persistence>`

- A tag <persistence> é a raiz do arquivo de configuração de persistência JPA. Ela define a versão da especificação JPA sendo usada (2.1 neste caso) e os namespaces XML associados.

### `<persistence-unit>`

- Dentro da tag <persistence-unit>, definimos uma unidade de persistência com o nome "projeto-spring-data-jpa". Isso permite que você agrupe várias classes de entidades e configurações relacionadas sob um único nome de unidade de persistência.

### `<class>`
- As tags <class> são usadas para listar as classes de entidades JPA que pertencem a esta unidade de persistência. Neste exemplo, temos duas classes: UsuarioSpringData e Telefone.

**Essas configurações são fundamentais para definir quais classes de entidades JPA serão gerenciadas pela unidade de persistência "projeto-spring-data-jpa". Isso permite que o Spring Data JPA identifique e gerencie as entidades do projeto.**

## Autor
### **Documentação feita por:** `Daniel Penelva de Andrade`
