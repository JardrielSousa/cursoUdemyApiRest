package br.com.cursoapirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.cursoapirest.entities.Empresa;
import br.com.cursoapirest.exceptions.EmpresaNaoEncontradaExceptions;
import br.com.cursoapirest.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<Empresa> listar(){
		return empresaRepository.findAll();
	}
	public Empresa buscarEmpresaPorId(Long empresaId) {
		Empresa empresa = empresaRepository.findById(empresaId).orElse(null);
		if(empresa == null) {
			
		}
		return empresa;
	}
	public Empresa salvarEmpresa(Empresa empresa) {
		empresa.setId(null);
		return empresaRepository.save(empresa) ;
	}
	public void deletarEmpresaPorId(Long EmpresaId) throws EmpresaNaoEncontradaExceptions {
			empresaRepository.deleteById(EmpresaId);
		
	}
	public void atualizarEmpresa(Empresa empresa) {
		verificaSeExiste(empresa);
		empresaRepository.save(empresa);
	}
	private void verificaSeExiste(Empresa empresa) {
		buscarEmpresaPorId(empresa.getId());
	}
}
