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
	private int conta;
	
	@NotBlank(message = "Campo Obrigatorio")
	private int digito;
	
	@NotBlank(message = "Campo Obrigatorio")
	private int agencia;
	
	@NotBlank(message = "Campo Obrigatorio")
	private int digitoAgencia;
	
	private double saldo;
	
	@NotBlank(message = "Campo Obrigatorio")
	private int cpfBeneficiario;

	
	public Conta () {	
	}
	
	public Conta (Long id, int conta, int digito, int agencia, int digitoAgencia, int cpfBeneficiario, double saldo) {
		this.id = id;
		this.conta = conta;
		this.digito = digito;
		this.digitoAgencia = digitoAgencia;
		this.agencia = agencia;
		this.cpfBeneficiario = cpfBeneficiario;
		this.saldo = saldo;
	}

	public int getDigitoAgencia() {
		return digitoAgencia;
	}

	public void setDigitoAgencia(int digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getDigito() {
		return digito;
	}

	public void setDigito(int digito) {
		this.digito = digito;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getCpfBeneficiario() {
		return cpfBeneficiario;
	}

	public void setCpfBeneficiario(int cpfBeneficiario) {
		this.cpfBeneficiario = cpfBeneficiario;
	}

	
}
