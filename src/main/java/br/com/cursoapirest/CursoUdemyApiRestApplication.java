package br.com.cursoapirest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.cursoapirest.Utils.SenhaUtils;

@SpringBootApplication
public class CursoUdemyApiRestApplication {
	
	@Value("${paginacao.qtdPorPagina}")
	private int valor;
	public static void main(String[] args) {
		SpringApplication.run(CursoUdemyApiRestApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args ->{
			System.out.println("quantidade:" + this.valor);
			String senha = SenhaUtils.gerarByCript("12345");
			System.out.println("senha encripted:" + senha);
			String senhaNew = SenhaUtils.gerarByCript("12345");
			System.out.println("senha encripted New:" + senhaNew);
			
			System.out.println("senha valida:" + SenhaUtils.validarSenha("12345", senha));
		};
	}

}
