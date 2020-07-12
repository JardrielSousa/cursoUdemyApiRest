package br.com.cursoapirest;

import java.util.Date;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.cursoapirest.entities.Empresa;
import br.com.cursoapirest.repositories.EmpresaRepository;
import br.com.cursoapirest.service.EmpresaService;

@RunWith(EasyMockRunner.class)
public class Test01Empresa{

	@TestSubject
	private EmpresaService empresaService;
	
	@Mock
	private EmpresaRepository empresaRepository;
	
	private Empresa empresa;

	@Before
	public void setup() {
		empresa = new Empresa();
		empresaService = EasyMock.createMock(EmpresaService.class);
		empresaRepository = EasyMock.createMock(EmpresaRepository.class);
	}
	
	@Test
	public void test01CriaEmpresa() {
		setarDados();
    	EasyMock.expect(empresaRepository.save(empresa)).andReturn(empresa);
	}

	private Empresa setarDados() {
		empresa.setId(5L);
		empresa.setDataAtualizacao(new Date());
		empresa.setDataCriacao(new Date());
		empresa.setCnpj("00001");
		empresa.setRazaoSocial("mock");
		return empresa;
	}
	
	@Test 
	public void test02BuscaEmpresaPorIdSucesso() {
		Empresa empresa = setarDados();
		EasyMock.expect(empresaService.buscarEmpresaPorId(empresa.getId())).andReturn(empresa);
	}
	

}
