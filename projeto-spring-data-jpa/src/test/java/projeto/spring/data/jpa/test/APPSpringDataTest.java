package projeto.spring.data.jpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class APPSpringDataTest {
	
	@Test
	public void testeInsert() {
		System.out.println("Iniciou Spring com sucesso!");
	}
}