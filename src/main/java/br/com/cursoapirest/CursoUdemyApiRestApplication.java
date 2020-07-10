package br.com.cursoapirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.cursoapirest.Utils.SenhaUtils;
import br.com.cursoapirest.entities.Empresa;
import br.com.cursoapirest.repositories.EmpresaRepository;

@SpringBootApplication
public class CursoUdemyApiRestApplication {
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	@Value("${paginacao.qtdPorPagina}")
	private int valor;
	public static void main(String[] args) {
		SpringApplication.run(CursoUdemyApiRestApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args ->{
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("j multimarcas");
			empresa.setCnpj("00001");
			empresaRepository.save(empresa);
			
			Empresa empresaCnpj = empresaRepository.findByCnpj("00001");
			System.out.println("empresa por cnpj: " + empresaCnpj);
			System.out.println("quantidade:" + this.valor);
			String senha = SenhaUtils.gerarByCript("12345");
			System.out.println("senha encripted:" + senha);
			String senhaNew = SenhaUtils.gerarByCript("12345");
			System.out.println("senha encripted New:" + senhaNew);
			
			System.out.println("senha valida:" + SenhaUtils.validarSenha("12345", senha));
		};
	}

}
