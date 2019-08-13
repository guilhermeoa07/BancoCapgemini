package com.BancoCapgemini.BancoCapgemini.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta {

	@Id 
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Campo Obrigatorio")
	private String conta;
	
	@NotBlank(message = "Campo Obrigatorio")
	private String digito;
	
	@NotBlank(message = "Campo Obrigatorio")
	private String agencia;
	
	@NotBlank(message = "Campo Obrigatorio")
	private String digitoAgencia;
	
	private double saldo;
	
	@NotBlank(message = "Campo Obrigatorio")
	private String cpfBeneficiario;
	
	@NotBlank(message = "Campo Obrigatorio")
	private String senha;

	
	public Conta () {	
	}
	
	public Conta (Long id, String conta, String senha, String digito, String agencia, String digitoAgencia, String cpfBeneficiario, double saldo) {
		this.id = id;
		this.conta = conta;
		this.senha = senha;
		this.digito = digito;
		this.digitoAgencia = digitoAgencia;
		this.agencia = agencia;
		this.cpfBeneficiario = cpfBeneficiario;
		
		this.saldo = saldo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDigitoAgencia() {
		return digitoAgencia;
	}

	public void setDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getDigito() {
		return digito;
	}

	public void setDigito(String digito) {
		this.digito = digito;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getCpfBeneficiario() {
		return cpfBeneficiario;
	}

	public void setCpfBeneficiario(String  cpfBeneficiario) {
		this.cpfBeneficiario = cpfBeneficiario;
	}

	
}
