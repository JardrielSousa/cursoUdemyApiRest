package br.com.cursoapirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursoapirest.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	Empresa findByCnpj(String cnpj);
	
}
