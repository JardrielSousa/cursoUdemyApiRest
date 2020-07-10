package br.com.cursoapirest.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.cursoapirest.enums.PerfilEnum;

@Entity
public class Funcionario {

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private BigDecimal valorHora;
	private float qtdHorasTrabalhadaDia;
	private float qtdHoraAlmoco;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private PerfilEnum perfil;
	private Empresa empresa;
	private List<Lancamento> lancamentos;
	
	public Funcionario() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(nullable = false,unique = true)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Column(nullable = true)
	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}


	public void setQtdHorasTrabalhadaDia(float qtdHorasTrabalhadaDia) {
		this.qtdHorasTrabalhadaDia = qtdHorasTrabalhadaDia;
	}
	@Column(nullable = true)
	public float getQtdHoraAlmoco() {
		return qtdHoraAlmoco;
	}

	public void setQtdHoraAlmoco(float qtdHoraAlmoco) {
		this.qtdHoraAlmoco = qtdHoraAlmoco;
	}
	@Column(nullable = false,name="data_criacao")
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	@Column(nullable = false,name="data_atualizacao")
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@OneToMany(mappedBy = "funcionario",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new java.util.Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", valorHora="
				+ valorHora + ", qtdHorasTrabalhadaDia=" + qtdHorasTrabalhadaDia + ", qtdHoraAlmoco=" + qtdHoraAlmoco
				+ ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
	
}
