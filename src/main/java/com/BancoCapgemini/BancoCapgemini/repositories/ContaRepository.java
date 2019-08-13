package com.BancoCapgemini.BancoCapgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BancoCapgemini.BancoCapgemini.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	Conta findByContaAndAgenciaAndDigito(String conta, String agencia, String digito);
}
