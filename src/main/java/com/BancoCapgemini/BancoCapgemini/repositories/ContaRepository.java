package com.BancoCapgemini.BancoCapgemini.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BancoCapgemini.BancoCapgemini.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	Optional<Conta> findByContaAndAgenciaAndDigito(String conta, String agencia, String digito);
	Optional<Conta> findByContaAndAgenciaAndDigitoAndSenha(String conta, String agencia, String digito, String senha);
}
