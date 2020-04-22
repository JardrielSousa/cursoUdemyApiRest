package br.com.cursoapirest;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;


@SpringBootTest
@ActiveProfiles("test")
class CursoUdemyApiRestApplicationTests {
	@Value("${paginacao.qtdPorPagina}")
	private int valor;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCarregarContextTest() {
		assertThat(valor);
	}

}
